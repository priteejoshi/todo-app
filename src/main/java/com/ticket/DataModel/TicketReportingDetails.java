package com.ticket.DataModel;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class TicketReportingDetails {
    
	
	private String agentID;
	private String reportedRequestType;
	private String reportedServiceLine;
	private String reportedTroubleDescirption;
	
	private LocalDateTime troubleReportedDate;
	private String problemAbstract;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ", locale = "en_GB")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	public LocalDateTime getTroubleReportedDate() {
		return troubleReportedDate;
	}


	public void setTroubleReportedDate(LocalDateTime troubleReportedDate) {
		this.troubleReportedDate = troubleReportedDate;
	}

	public TicketReportingDetails(String agentID, String reportedRequestType,
			String reportedServiceLine, String reportedTroubleDescirption,
			LocalDateTime troubleReportedDate, String problemAbstract) {
		super();
		this.agentID = agentID;
		this.reportedRequestType = reportedRequestType;
		this.reportedServiceLine = reportedServiceLine;
		this.reportedTroubleDescirption = reportedTroubleDescirption;
		this.troubleReportedDate = troubleReportedDate;
		this.problemAbstract = problemAbstract;
	}
	
	
	public String getAgentID() {
		return agentID;
	}
	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}
	public String getReportedRequestType() {
		return reportedRequestType;
	}
	public void setReportedRequestType(String reportedRequestType) {
		this.reportedRequestType = reportedRequestType;
	}
	public String getReportedServiceLine() {
		return reportedServiceLine;
	}
	public void setReportedServiceLine(String reportedServiceLine) {
		this.reportedServiceLine = reportedServiceLine;
	}
	public String getReportedTroubleDescirption() {
		return reportedTroubleDescirption;
	}
	public void setReportedTroubleDescirption(String reportedTroubleDescirption) {
		this.reportedTroubleDescirption = reportedTroubleDescirption;
	}
	


	public String getProblemAbstract() {
		return problemAbstract;
	}


	public void setProblemAbstract(String problemAbstract) {
		this.problemAbstract = problemAbstract;
	}


	@Override
	public String toString() {
		return "TicketReportingDetails [agentID=" + agentID
				+ ", reportedRequestType=" + reportedRequestType
				+ ", reportedServiceLine=" + reportedServiceLine
				+ ", reportedTroubleDescirption=" + reportedTroubleDescirption
				+ ", troubleReportedDate=" + troubleReportedDate
				+ ", problemAbstract=" + problemAbstract + "]";
	}
	
	
	
	
}
