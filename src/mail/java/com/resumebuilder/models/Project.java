package com.resumebuilder.models;

public class Project {
    private String title;
    private String description;
    private String technologies;
    private String startDate;
    private String endDate;

    public Project(String title, String description, String technologies, String startDate, String endDate) {
        this.title = title;
        this.description = description;
        this.technologies = technologies;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters...
}
