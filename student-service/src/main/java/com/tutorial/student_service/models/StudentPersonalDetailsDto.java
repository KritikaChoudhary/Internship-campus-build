package com.tutorial.student_service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class StudentPersonalDetailsDto {

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


    //STUDENT NAME DETAIL

    @JsonProperty("studentName")
    @NotBlank(message = "Student name cannot be null")
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    //STUDENT EMAIL DETAIL

    @Email
    @JsonProperty("studentEmail")
    @NotBlank(message = "Student email cannot be null")
    private String studentEmail;

    public String getStudentEmail() { return studentEmail; }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    //STUDENT PROFILE IMAGE DETAIL
    
    @JsonProperty("profileImage")
    private String profileImage;
    
    public String getProfileImage() { return profileImage; }
    
    public void setProfileImage(String profileImage) {
    	this.profileImage = profileImage;
    }
    
    //STUDENT COLLEGE DETAILS
    
    @JsonProperty("cllegeId")
    private String collegeId;
    
    public String getCollegeId() { return collegeId; }
    
    public void setCollegeId (String collegeId) {
    	this.collegeId = collegeId;
    }
}