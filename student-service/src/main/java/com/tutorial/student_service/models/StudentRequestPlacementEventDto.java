package com.tutorial.student_service.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentRequestPlacementEventDto {

    @JsonProperty("collegeId")
    @JsonPropertyDescription("Id of the college")
    @NotNull(message="College id cannot be null")
    @NotNull(message="College id cannot be empty")
    String collegeId;

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }


    @JsonProperty("studentCgpa")
    @JsonPropertyDescription("CGPA of the student")
    @NotNull(message="Student CGPA cannot be null")
    @NotNull(message="Student CGPA cannot be empty")
    String studentCgpa;

    public String getStudentCgpa() {
        return studentCgpa;
    }

    public void setStudentCgpa(String studentCgpa) { this.studentCgpa = studentCgpa; }


    @JsonProperty("placementEventStatus")
    @JsonPropertyDescription("Status of the placement event.")
    @NotBlank(message = "Placement event status cannot be null.")
    @NotBlank(message = "Placement event status cannot be empty.")
    private String placementEventStatus;

    public String getPlacementEventStatus() { return placementEventStatus; }

    public void setPlacementEventStatus(String placementEventStatus) { this.placementEventStatus = placementEventStatus; }
}
