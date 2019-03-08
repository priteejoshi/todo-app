package com.ticket.DataModel;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ticket.repository.CounterServiceImpl;


@Document(collection = "Ticket")
public class Ticket {
@Id
private String id;

private String ticketNo;
private String functionalSupport;
private String workGroup;
private String ticketType;
private String severity;
private  String ticketState;
private String ticketPriority;
private LocalDate ticketOpenDate;
private LocalDate ticketClosedDate;
private TicketReportingDetails ticketReportingDetails;
private AssetDetails assetDetails;
private List<TicketResolutionDetails> ticketResolutionDetails;

private List<TicketLogDetails> ticketLogDetails=new ArrayList<TicketLogDetails>();
private List<WorkAssignmentDetails> workAssignmentDetails = new ArrayList<WorkAssignmentDetails>();
protected  CounterServiceImpl counterService;



public Ticket(String id, String ticketNo, String functionalSupport,
        String workGroup, String ticketType, String severity,
        String ticketState, String ticketPriority, LocalDate ticketOpenDate,
        LocalDate ticketClosedDate, TicketReportingDetails ticketReportingDetails,
        AssetDetails assetDetails,
        List<TicketResolutionDetails> ticketResolutionDetails,
        List<TicketLogDetails> ticketLogDetails,
        List<WorkAssignmentDetails> workAssignmentDetails
        ) {
	super();
	this.id = id;
	this.ticketNo = ticketNo;
	this.functionalSupport = functionalSupport;
	this.workGroup = workGroup;
	this.ticketType = ticketType;
	this.severity = severity;
	this.ticketState = ticketState;
	this.ticketPriority = ticketPriority;
	this.ticketOpenDate = ticketOpenDate;
	this.ticketClosedDate = ticketClosedDate;
	this.ticketReportingDetails = ticketReportingDetails;
	this.assetDetails = assetDetails;
	this.ticketResolutionDetails = ticketResolutionDetails;
	this.ticketLogDetails = ticketLogDetails;
	this.workAssignmentDetails = workAssignmentDetails;
	
	
}


public List<TicketResolutionDetails> getTicketResolutionDetails() {
	return ticketResolutionDetails;
}
public void setTicketResolutionDetails(
		List<TicketResolutionDetails> ticketResolutionDetails) {
	this.ticketResolutionDetails = ticketResolutionDetails;
}

public List<WorkAssignmentDetails> getWorkAssignmentDetails() {
	return workAssignmentDetails;
}
public void setWorkAssignmentDetails(
		List<WorkAssignmentDetails> workAssignmentDetails) {
	this.workAssignmentDetails = workAssignmentDetails;
}
public TicketReportingDetails getTicketReportingDetails() {
	return ticketReportingDetails;
}
public void setTicketReportingDetails(
		TicketReportingDetails ticketReportingDetails) {
	this.ticketReportingDetails = ticketReportingDetails;
}
public AssetDetails getAssetDetails() {
	return assetDetails;
}
public void setAssetDetails(AssetDetails assetDetails) {
	this.assetDetails = assetDetails;
}
public String getId() {
	return id;
}
public String getTicketNo() {
	return ticketNo;
}
public String getFunctionalSupport() {
	return functionalSupport;
}
public String getWorkGroup() {
	return workGroup;
}
public String getTicketType() {
	return ticketType;
}
public String getSeverity() {
	return severity;
}
public void setId(String id) {
	this.id = id;
}
public void setTicketNo(String ticketNo) {
	this.ticketNo = ticketNo;
}
public void setFunctionalSupport(String functionalSupport) {
	this.functionalSupport = functionalSupport;
}
public void setWorkGroup(String workGroup) {
	this.workGroup = workGroup;
}
public void setTicketType(String ticketType) {
	this.ticketType = ticketType;
}
public void setSeverity(String severity) {
	this.severity = severity;
}
public String getTicketState() {
	return ticketState;
}
public void setTicketState(String ticketState) {
	this.ticketState = ticketState;
}
public List<TicketLogDetails> getTicketLogDetails() {
	return ticketLogDetails;
}
public void setTicketLogDetails(List<TicketLogDetails> ticketLogDetails) {
	this.ticketLogDetails = ticketLogDetails;
}



public String getTicketPriority() {
	return ticketPriority;
}


public void setTicketPriority(String ticketPriority) {
	this.ticketPriority = ticketPriority;
}


public LocalDate getTicketOpenDate() {
	return ticketOpenDate;
}
public void setTicketOpenDate(LocalDate ticketOpenDate) {
	this.ticketOpenDate = ticketOpenDate;
}
public LocalDate getTicketClosedDate() {
	return ticketClosedDate;
}
public void setTicketClosedDate(LocalDate ticketClosedDate) {
	this.ticketClosedDate = ticketClosedDate;
}
public CounterServiceImpl getCounterService() {
	return counterService;
}
public void setCounterService(CounterServiceImpl counterService) {
	this.counterService = counterService;
}
@Override
public String toString() {
	return "Ticket [id=" + id + ", ticketNo=" + ticketNo
	        + ", functionalSupport=" + functionalSupport + ", workGroup="
	        + workGroup + ", ticketType=" + ticketType + ", severity="
	        + severity + ",ticket ticketState=" + ticketState + ", priority="
	        + ticketPriority + ", ticketOpenDate=" + ticketOpenDate
	        + ", ticketClosedDate=" + ticketClosedDate
	        + ", ticketReportingDetails=" + ticketReportingDetails
	        + ", assetDetails=" + assetDetails + ", ticketResolutionDetails="
	        + ticketResolutionDetails + ", ticketLogDetails="
	        + ticketLogDetails + ", counterService=" + counterService
	        + ", workAssignmentDetails=" + workAssignmentDetails + "]";
}


}
