package com.tutorial.student_service.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public class StudentSgpaDto {
	
	//STUDENT USN DETAIL

    @JsonProperty("studentUsn")
    @JsonPropertyDescription("University student number of the student")
    @NotBlank(message = "USN number cannot be null or empty")
    @Valid
    private String studentUsn;

    public String getStudentUsn() {
        return studentUsn;
    }

    public void setStudentUsn(String studentUsn) {
        this.studentUsn = studentUsn;
    }
    
    //STUDENT CGPA DETAIL
    
    @JsonProperty("studentCGPA")
    @NotBlank(message = "Grade value cannot be null or empty")
    private String studentCGPA;
    
    public String getStudentCGPA() {
    	return studentCGPA;
    }
    
    public void setStudentCGPA(String studentCGPA) {
    	this.studentCGPA = studentCGPA;
    }
}
