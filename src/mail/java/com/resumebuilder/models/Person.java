package com.resumebuilder.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String phoneNumber;
    private String email;
    private String linkedIn;
    private String repositoryLink;
    private String address;
    private List<Skill> skills;
    private List<Education> educationList;
    private List<Experience> experiences;
    private List<Certification> certifications;
    private List<Award> awards;
    private List<Project> projects;
    private List<Publication> publications;
    private List<VolunteerExperience> volunteerExperiences;
    private List<Language> languages;

    public Person() {
        this.skills = new ArrayList<>();
        this.educationList = new ArrayList<>();
        this.experiences = new ArrayList<>();
        this.certifications = new ArrayList<>();
        this.awards = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.publications = new ArrayList<>();
        this.volunteerExperiences = new ArrayList<>();
        this.languages = new ArrayList<>();
    }

    // Getters and setters...

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public void addExperience(Experience experience) {
        this.experiences.add(experience);
    }

    public void addCertification(Certification certification) {
        this.certifications.add(certification);
    }

    public void addAward(Award award) {
        this.awards.add(award);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void addPublication(Publication publication) {
        this.publications.add(publication);
    }

    public void addVolunteerExperience(VolunteerExperience volunteerExperience) {
        this.volunteerExperiences.add(volunteerExperience);
    }

    public void addLanguage(Language language) {
        this.languages.add(language);
    }
}
