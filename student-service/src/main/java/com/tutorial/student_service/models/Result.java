package com.tutorial.student_service.models;

public class Result {

	SendResponse res;
	StudentSgpaDto cgpa;
	
	public SendResponse getRes() {
		return res;
	}
	
	public StudentSgpaDto getCGPA() {
		return cgpa;
	}
	
	public void setRes(SendResponse r) {
		res = r;
	}
	
	public void setCGPA(StudentSgpaDto s) {
		cgpa = s;
	}
}
