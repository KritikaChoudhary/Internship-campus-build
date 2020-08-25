package com.tutorial.student_service.models;

public class PlacementDetails {
	
	String date;
	String status;
	
	public PlacementDetails() {
		
	}
	
	public PlacementDetails(String date, String status) {
		super();
		setDate(date);
		setStatus(status);
	}
	
	public String getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
