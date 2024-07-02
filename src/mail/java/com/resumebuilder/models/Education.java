package com.resumebuilder.models;

public class Education {
    private String degree;
    private String major;
    private String minor;
    private String institution;
    private String startDate;
    private String endDate;
    private String additionalInfo;

    public Education(String degree, String major, String minor, String institution, String startDate, String endDate, String additionalInfo) {
        this.degree = degree;
        this.major = major;
        this.minor = minor;
        this.institution = institution;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additionalInfo = additionalInfo;
    }

    // Getters and setters...
}
