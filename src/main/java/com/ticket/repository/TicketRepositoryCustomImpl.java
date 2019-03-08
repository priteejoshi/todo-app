package com.ticket.repository;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.ticket.DataModel.Ticket;
import com.ticket.DataModel.TicketResolutionDetails;
import com.ticket.DataModel.WorkAssignmentDetails;

@Service
public   class TicketRepositoryCustomImpl implements TicketRepositoryCustom{
	@Autowired
	MongoTemplate mongoTemplate;

	
	
	public List<Ticket> getLastFetchedTickets(String lastFetchedDate) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(lastFetchedDate, formatter);

		Query query = new Query();
		query.addCriteria(Criteria.where("ticketReportingDetails.troubleReportedDate").gte(dateTime));
		return mongoTemplate.find(query, Ticket.class);
		
	}

	public Ticket updateAssignment(String ticketNo,
			WorkAssignmentDetails assignment) {
		// TODO Auto-generated method stub
		
		String WorkqueFromDB=null;
		Query query1 = new Query();
		DBObject Obj = new BasicDBObject();
		Obj.put("workNotes",assignment.getWorkNotes());
		
		String workquee=assignment.getWorkQueue();
		Obj.put("workQueue", assignment.getWorkQueue());
		
	    System.out.println("the element we are inserting ### " + assignment.getWorkQueue());
		query1.addCriteria(Criteria.where("ticketNo").is(ticketNo));
		 Ticket ticket=mongoTemplate.findOne(query1, Ticket.class);
		System.out.println("assignment::::"+assignment);
		
		List<WorkAssignmentDetails> list=ticket.getWorkAssignmentDetails();
		System.out.println(" workassignmentdetails in ticket class  @@@ " + list);
		int count=0;
		for(WorkAssignmentDetails assignmentDetails:list){
			
			WorkqueFromDB=assignmentDetails.getWorkQueue();
			 System.out.println("WorkqueFromDB ::: " + WorkqueFromDB);
				
			 if(workquee.equals(WorkqueFromDB)){
				 count=1;
				 System.out.println("Failed to update...assignment already exists" );
				 break;
			 }
		}
	if (count==0){
	Update update1=new Update().push("workAssignmentDetails",Obj);
	
    mongoTemplate.updateFirst(query1, update1, Ticket.class);
   // mongoTemplate.findOne(query1,Ticket.class);
	}
    System.out.println("assignment"+assignment);
	return mongoTemplate.findOne(query1,Ticket.class);
		
		
	}

	public Ticket updateTicketState(String ticketNo,
			WorkAssignmentDetails assignment) {
		// TODO Auto-generated method stub
		
		Query query1 = new Query();
		DBObject obj = new BasicDBObject();
		List<WorkAssignmentDetails> obj_list=new ArrayList<WorkAssignmentDetails>();
		query1.addCriteria(Criteria.where("ticketNo").is(ticketNo));
		System.out.println("query1 == " + query1);
		 Ticket ticket1=mongoTemplate.findOne(query1, Ticket.class);
		System.out.println("ticket == " + ticket1);
		Update update=new Update().set("ticketState", "Active");
		System.out.println("****** " + update);
	    mongoTemplate.updateFirst(query1, update, Ticket.class);
		
		List<WorkAssignmentDetails> list=ticket1.getWorkAssignmentDetails();
		System.out.println(" list == " + list );
		for(WorkAssignmentDetails assignmentDetails:list){
		obj.put("userId",assignment.getUserId());
		obj.put("userName", assignment.getUserName());
		obj.put("workQueue",assignmentDetails.getWorkQueue());
		obj.put("workNotes",assignmentDetails.getWorkNotes());
		obj_list.add((WorkAssignmentDetails) obj);
		Update update1=new Update().set("workAssignmentDetails",obj_list);
		System.out.println("========== " + update1);
	    mongoTemplate.updateFirst(query1, update1, Ticket.class);
		
		}
		
		 return mongoTemplate.findOne(query1,Ticket.class);
	}

	public Ticket updateTicketResolution(String ticketNo,
            TicketResolutionDetails ticketResolutionDetails) {
	    // TODO Auto-generated method stub
		Query query1 = new Query();
		DBObject obj = new BasicDBObject();
		//obj.put("ticketResolutionDetails", ticketResolutionDetails);
		query1.addCriteria(Criteria.where("ticketNo").is(ticketNo));
		System.out.println("query1 == " + query1);
		 Ticket ticket1=mongoTemplate.findOne(query1, Ticket.class);
		System.out.println("ticket == " + ticket1);
		Update update=new Update().set("ticketState", "Closed");
		System.out.println("****** " + update);
	    mongoTemplate.updateFirst(query1, update, Ticket.class);
	    if(ticket1.getTicketState().equals("Closed"))
	    {
	    	Update update2=new Update().push("ticketReesolutionDetails", ticketResolutionDetails);
	    	  mongoTemplate.updateFirst(query1, update2, Ticket.class);
	    }
		
	    return mongoTemplate.findOne(query1,Ticket.class);   
    }
    
	
		
	public Ticket updateTicketPriority(String ticketNo,String ticketPriority,Long resolutionTime) {
		Query query1 = new Query();
		System.out.println("ticket == " + ticketNo+"  "+ticketPriority+" "+resolutionTime);
		
		query1.addCriteria(Criteria.where("ticketNo").is(ticketNo));
		 Ticket ticket1=mongoTemplate.findOne(query1, Ticket.class);
			Update update=new Update().set("ticketPriority",ticketPriority);
			
			update.set("ticketClosedDate",ticket1.getTicketOpenDate().plusDays(resolutionTime));
			
			System.out.println("****** " + update);
		    mongoTemplate.updateFirst(query1, update, Ticket.class);
		
		    return mongoTemplate.findOne(query1,Ticket.class);    
	}
		    
	
	
}
