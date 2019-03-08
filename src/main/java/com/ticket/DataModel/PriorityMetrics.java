package com.ticket.DataModel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PriorityMetrics")
public class PriorityMetrics {
	
	private String type;
	private String subType;
	private String severity;
	private String priority;
	private long acknowledgedTime;
	private long plannedResolutionTime;
	
	public PriorityMetrics(String type, String subType, String severity,
            String priority, long acknowledgedTime,
            long plannedResolutionTime) {
	    super();
	    this.type = type;
	    this.subType = subType;
	    this.severity = severity;
	    this.priority = priority;
	    this.acknowledgedTime = acknowledgedTime;
	    this.plannedResolutionTime = plannedResolutionTime;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public long getAcknowledgedTime() {
		return acknowledgedTime;
	}

	public void setAcknowledgedTime(long acknowledgedTime) {
		this.acknowledgedTime = acknowledgedTime;
	}

	public long getPlannedResolutionTime() {
		return plannedResolutionTime;
	}

	public void setPlannedResolutionTime(long plannedResolutionTime) {
		this.plannedResolutionTime = plannedResolutionTime;
	}

	@Override
    public String toString() {
	    return "PriorityMetrics [type=" + type + ", subType=" + subType
	            + ", severity=" + severity + ", priority=" + priority
	            + ", acknowledgedTime=" + acknowledgedTime
	            + ", plannedResolutionTime=" + plannedResolutionTime + "]";
    }
	
	
	
	
}
