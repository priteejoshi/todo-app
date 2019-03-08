package com.ticket.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.ticket.DataModel.Ticket;
import com.ticket.DataModel.TicketResolutionDetails;
import com.ticket.DataModel.WorkAssignmentDetails;

public interface TicketRepositoryCustom {
	public List<Ticket> getLastFetchedTickets(String fDate);
	public Ticket updateTicketState(String ticketNo,WorkAssignmentDetails ticket);
	public Ticket updateAssignment(String ticketNo,WorkAssignmentDetails assignment);
	public Ticket updateTicketResolution(String ticketNo,TicketResolutionDetails ticketResolutionDetails);
	public Ticket updateTicketPriority(String ticketNo,String ticketPriority,Long ticketReolutionTime);
	
}
