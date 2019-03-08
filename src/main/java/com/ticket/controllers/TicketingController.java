package com.ticket.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.DataModel.PriorityMetrics;
import com.ticket.DataModel.Ticket;
import com.ticket.DataModel.TicketResolutionDetails;
import com.ticket.DataModel.WorkAssignmentDetails;
import com.ticket.bean.HelloMessage;
import com.ticket.repository.CounterRepository;
import com.ticket.repository.CounterServiceImpl;
import com.ticket.repository.PriorityMetricsRepository;
import com.ticket.repository.TicketRepository;
import com.ticket.repository.TicketRepositoryCustom;
import com.ticket.repository.TicketRepositoryCustomImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tickets")
@Api(value = "tickets", description = "Rest API for Trouble Ticketing operations", tags = "External API")
public class TicketingController {

	  @Autowired
	  MongoTemplate mongoTemplate;
	    
	  @Autowired 
	   CounterRepository counterRepository;
	   
	  @Autowired 
	   CounterServiceImpl counterService;
	  
	  @Autowired
	  PriorityMetricsRepository metricsRepository;
	  
	  
	  
	  @Autowired
	  TicketRepository  ticketRepository;
	
	@Autowired
	TicketRepositoryCustomImpl	ticketSearchService;
	
	

	@RequestMapping(value="/hello", method = RequestMethod.GET, produces = "application/json")
	 @ApiOperation(value = "Say 'Hi' to the External user", response = HelloMessage.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public HelloMessage hello(@RequestParam String name) {
	        System.out.println(name + " trying to login.");
	        HelloMessage helloMessage = new HelloMessage(name, "Hi Admin " + name + ", Happy Learning...");
	        return helloMessage;
	    }
	


    @RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
	 @ApiOperation(value = "Retrieve all ticket details:", response = HelloMessage.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    }
    )

	public List<Ticket> getAll() {
		List<Ticket> tickets = (List<Ticket>) ticketRepository.findAll();
		
		return tickets;
	}


    @RequestMapping(value="/create", method = RequestMethod.PUT, produces = "application/json")
	 @ApiOperation(value = "Ticket Creation", response = HelloMessage.class)
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "OK"),
           @ApiResponse(code = 401, message = "You are not authorized access the resource"),
           @ApiResponse(code = 404, message = "The resource not found")
   }
   )
	public void insert(@RequestBody Ticket ticket) { // @RequestBody
		 // TicketLogDetails
	 // ticketLogDetails
System.out.println(ticket);
String cnt="TT"+counterService.getNextSequence("ticket_no");
ticket.setTicketNo(cnt);
Calendar calendar = Calendar.getInstance();
Date now = calendar.getTime();
//Timestamp currentTimestamp = new Timestamp(now.getTime());
LocalDate localDate=now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
ticket.setTicketOpenDate(localDate);
ticketRepository.save(ticket);
}
	
    @RequestMapping(value="/search", method = RequestMethod.GET, produces = "application/json")
	 @ApiOperation(value = "Retrieve all ticket details:", response = HelloMessage.class)
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "OK"),
           @ApiResponse(code = 401, message = "You are not authorized access the resource"),
           @ApiResponse(code = 404, message = "The resource not found")
   }
   )

    public List<Ticket>  GetLastTicket( @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam("LastFetchedDate") String LastFetchedDate)  {
		List<Ticket> tickets = (List<Ticket>) ticketRepository.getLastFetchedTickets(LastFetchedDate);

		return tickets;
	}
	
    
    @RequestMapping(value="/assignment", method = RequestMethod.PUT, produces = "application/json")
	 @ApiOperation(value = "Retrieve all ticket details:", response = HelloMessage.class)
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "OK"),
           @ApiResponse(code = 401, message = "You are not authorized access the resource"),
           @ApiResponse(code = 404, message = "The resource not found")
   })
    public Ticket update(@RequestParam String TicketNo,@RequestBody WorkAssignmentDetails assignment) {
        
	 
	 Ticket workassign=ticketSearchService.updateAssignment( TicketNo, assignment);
        

        return workassign ;
    }


	@PutMapping("/updateTicketState")
	public Ticket updateTicketState(@RequestParam String ticketNo,
	        @RequestBody WorkAssignmentDetails ticket) {
		
		Ticket ticket1 = ticketSearchService
		        .updateTicketState(ticketNo, ticket);
		
		return ticket1;
	}
	
	@PutMapping("/updateTicketResolution")
	public Ticket updateTicketResolution(@RequestParam String ticketNo,
	        @RequestBody TicketResolutionDetails ticketResolutionDetails) {
		Ticket ticket = ticketSearchService.updateTicketResolution(ticketNo,
		        ticketResolutionDetails);
				return ticket;
	}
	
	@PutMapping("/updateTicketPriority")
	public Ticket updateTicketPriority(@RequestParam String ticketNo,
			@RequestParam String priority) {
		PriorityMetrics metrics=metricsRepository.findByPriorityAndTypeAndSubType(priority,"Fault","Congestion");
		System.out.println(metrics.getPlannedResolutionTime());
		Ticket ticket = ticketSearchService.updateTicketPriority(ticketNo,priority,metrics.getPlannedResolutionTime());
		return ticket;
		
				
	}
    @RequestMapping(value="/assignment", method = RequestMethod.POST, produces = "application/json")
	 @ApiOperation(value = "Retrieve all ticket details:", response = HelloMessage.class)
   @ApiResponses(value = {
           @ApiResponse(code = 200, message = "OK"),
           @ApiResponse(code = 401, message = "You are not authorized access the resource"),
           @ApiResponse(code = 404, message = "The resource not found")
   })
	
	    public Ticket updateAssignment(@RequestParam String TicketNo,@RequestBody String jsonString){
		 ObjectMapper mapper = new ObjectMapper();
		    JsonNode actualObj;
			try {
				actualObj = mapper.readTree(jsonString);
				  String ticketPriority = actualObj.get("ticketPriority").textValue();
				    String workQueue = actualObj.get("workQueue").textValue();
				    String workNotes = actualObj.get("workNotes").textValue();
				    WorkAssignmentDetails assignment=new WorkAssignmentDetails(workQueue,"","",workNotes);
				    
				    Ticket workassign = ticketSearchService.updateAssignment(TicketNo,
					        assignment);
				    Ticket ticket_priority=updateTicketPriority(TicketNo,ticketPriority);
					return ticket_priority;		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		    
		
			    
		
	    }   

    
}
