package com.ticket.DataModel;

public class WorkAssignmentDetails {
	
	private String workQueue;
	private String userId;
	private String userName;
	private String workNotes;
	
	
	
	public WorkAssignmentDetails(String workQueue, String userId,
			String userName, String workNotes) {
		super();
		this.workQueue = workQueue;
		this.userId = userId;
		this.userName = userName;
		this.workNotes = workNotes;
	}
	
	public String getWorkQueue() {
		return workQueue;
	}
	public void setWorkQueue(String workQueue) {
		this.workQueue = workQueue;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getWorkNotes() {
		return workNotes;
	}

	public void setWorkNotes(String workNotes) {
		this.workNotes = workNotes;
	}

	@Override
	public String toString() {
		return "WorkAssignmentDetails [workQueue=" + workQueue + ", userId="
				+ userId + ", userName=" + userName + ", workNotes="
				+ workNotes + "]";
	}

	
	
	

}
