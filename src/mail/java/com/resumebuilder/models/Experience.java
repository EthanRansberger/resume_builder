package com.resumebuilder.models;

public class Experience {
    private String title;
    private String company;
    private String startDate;
    private String endDate;
    private String description;

    public Experience(String title, String company, String startDate, String endDate, String description) {
        this.title = title;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    // Getters and setters...
}
