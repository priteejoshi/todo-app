package com.ticket.DataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.ticket.repository.TicketRepository;
@SpringBootApplication 
@EnableMongoRepositories(basePackageClasses = TicketRepository.class) 
@Component
public class TicketUpdates implements CommandLineRunner  {
	@Autowired
private TicketRepository ticketRepository;
public TicketUpdates(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
}
public void run(String... strings) throws Exception {
	//Date D1 = new Date();
   
    
    // drop all hotels
   // this.ticketRepository.deleteAll();
  //add tickets to the database
    
    //TicketReportingDetails tdetails=new TicketReportingDetails("TS","Fault","VoLTE","Congesion","2018-03-29 10:10:10","MaxRRS connection exceeded threshold at");
	  //AssetDetails assetDetails=new AssetDetails("806207", "eNodeB", "LMMUM62076", "Mumbai", "West");
    //Ticket T1 = new Ticket("TT101","Mobile Network Sopport","Network Related","Critical","TechM",tdetails,assetDetails);
    //List<Ticket> tickets = Arrays.asList(T1);
    //this.ticketRepository.saveAll(tickets);
}
}
