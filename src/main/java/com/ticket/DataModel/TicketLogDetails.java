package com.ticket.DataModel;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class TicketLogDetails {
	
	private String ticketLog;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date ticketLogDate;
	
	public TicketLogDetails(String ticketLog, Date ticketLogDate) {
	    super();
	    this.ticketLog = ticketLog;
	    this.ticketLogDate = ticketLogDate;
    }
	
	public String getTicketLog() {
		return ticketLog;
	}
	public void setTicketLog(String ticketLog) {
		this.ticketLog = ticketLog;
	}
	public Date getTicketLogDate() {
		return ticketLogDate;
	}
	public void setTicketLogDate(Date ticketLogDate) {
		this.ticketLogDate = ticketLogDate;
	}

	@Override
    public String toString() {
	    return "TicketLogDetails [ticketLog=" + ticketLog + ", ticketLogDate="
	            + ticketLogDate + "]";
    }
	
	
	
}
