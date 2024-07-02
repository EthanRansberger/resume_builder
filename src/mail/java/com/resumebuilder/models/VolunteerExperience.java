package com.resumebuilder.models;

public class VolunteerExperience {
    private String role;
    private String organization;
    private String startDate;
    private String endDate;
    private String description;

    public VolunteerExperience(String role, String organization, String startDate, String endDate, String description) {
        this.role = role;
        this.organization = organization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    // Getters and setters...
}
