package com.tutorial.student_service.models;


public class PlacementEventDetails {

    private String placementEventId;

    public String getPlacementEventId() { return placementEventId; }

    public void setPlacementEventId(String placementEventId) { this.placementEventId = placementEventId; }


    private String companyId;

    public String getCompanyId() { return companyId; }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }


    private String collegeId;

    public String getCollegeId() { return collegeId; }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }


    private String placementEventDate;

    public String getPlacementEventDate() { return placementEventDate; }

    public void setPlacementEventDate(String placementEventDate) {
        this.placementEventDate = placementEventDate;
    }


    private String placementEventStatus;

    public String getPlacementEventStatus() { return placementEventStatus; }

    public void setPlacementEventStatus(String placementEventStatus) {
        this.placementEventStatus = placementEventStatus;
    }



    public void setValues(String placementEventDate, String placementEventId, String collegeId, String placementEventStatus) {
        this.placementEventDate = placementEventDate;
        this.placementEventId = placementEventId;
        this.collegeId = collegeId;
        this.placementEventStatus = placementEventStatus;
        this.companyId = "";
    }
}
