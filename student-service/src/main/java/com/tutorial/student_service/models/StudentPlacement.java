package com.tutorial.student_service.models;

import java.util.List;

import org.springframework.http.ResponseEntity;

public class StudentPlacement {

	private SendResponse response;
	private ResponseEntity<List<StudentPersonalDetailsDto>> student;
	
	public StudentPlacement(SendResponse s, ResponseEntity<List<StudentPersonalDetailsDto>> d) {
		response = s;
		student = d;
	}
	
	public SendResponse response() {
		return response;
	}
	
	public ResponseEntity<List<StudentPersonalDetailsDto>> student() {
		return student;
	}
}
