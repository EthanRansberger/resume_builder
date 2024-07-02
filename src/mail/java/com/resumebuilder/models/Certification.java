package com.resumebuilder.models;

public class Certification {
    private String name;
    private String issuingOrg;
    private String issueDate;
    private String expirationDate;

    public Certification(String name, String issuingOrg, String issueDate, String expirationDate) {
        this.name = name;
        this.issuingOrg = issuingOrg;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
    }

    // Getters and setters...
}
