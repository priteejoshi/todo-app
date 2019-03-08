package com.ticket.DataModel;

import java.util.Date;

public class TicketResolutionDetails {
	private String resolutionServiceLine;
	private String resolutionAction;
	private String resolutionCause;
	private String resolutionDescription;
	private Date troubleResolutionDate;
	
	public TicketResolutionDetails(String resolutionServiceLine,
            String resolutionAction, String resolutionCause,
            String resolutionDescription, Date troubleResolutionDate) {
	    super();
	    this.resolutionServiceLine = resolutionServiceLine;
	    this.resolutionAction = resolutionAction;
	    this.resolutionCause = resolutionCause;
	    this.resolutionDescription = resolutionDescription;
	    this.troubleResolutionDate = troubleResolutionDate;
    }
	public String getResolutionServiceLine() {
		return resolutionServiceLine;
	}
	public void setResolutionServiceLine(String resolutionServiceLine) {
		this.resolutionServiceLine = resolutionServiceLine;
	}
	public String getResolutionAction() {
		return resolutionAction;
	}
	public void setResolutionAction(String resolutionAction) {
		this.resolutionAction = resolutionAction;
	}
	public String getResolutionCause() {
		return resolutionCause;
	}
	public void setResolutionCause(String resolutionCause) {
		this.resolutionCause = resolutionCause;
	}
	public String getResolutionDescription() {
		return resolutionDescription;
	}
	public void setResolutionDescription(String resolutionDescription) {
		this.resolutionDescription = resolutionDescription;
	}
	public Date getTroubleResolutionDate() {
		return troubleResolutionDate;
	}
	public void setTroubleResolutionDate(Date troubleResolutionDate) {
		this.troubleResolutionDate = troubleResolutionDate;
	}
	@Override
    public String toString() {
	    return "TicketResolutionDetails [resolutionServiceLine="
	            + resolutionServiceLine + ", resolutionAction="
	            + resolutionAction + ", resolutionCause=" + resolutionCause
	            + ", resolutionDescription=" + resolutionDescription
	            + ", troubleResolutionDate=" + troubleResolutionDate + "]";
    }
	
	
	
	
}
