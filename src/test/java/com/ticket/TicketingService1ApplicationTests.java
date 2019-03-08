package com.ticket;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;

import com.ticket.DataModel.Ticket;
import com.ticket.repository.TicketRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketingService1ApplicationTests {
	 
	    private TicketRepository ticketRepository;
		 
	 
	@Test
	public void contextLoads() {
	}

}
