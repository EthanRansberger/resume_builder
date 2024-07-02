package com.resumebuilder.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String phone;
    private String email;
    private String linkedin;
    private String repo;
    private String address;
    private List<Education> educationList;
    private List<Experience> experienceList;
    private List<Skill> skillList;
    private List<Certification> certificationList;
    private List<Award> awardList;
    private List<Language> languageList;
    private List<Project> projectList;
    private List<Publication> publicationList;

    public Person() {
        educationList = new ArrayList<>();
        experienceList = new ArrayList<>();
        skillList = new ArrayList<>();
        certificationList = new ArrayList<>();
        awardList = new ArrayList<>();
        languageList = new ArrayList<>();
        projectList = new ArrayList<>();
        publicationList = new ArrayList<>();
    }

    // Getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void addExperience(Experience experience) {
        this.experienceList.add(experience);
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void addSkill(Skill skill) {
        this.skillList.add(skill);
    }

    public List<Certification> getCertificationList() {
        return certificationList;
    }

    public void addCertification(Certification certification) {
        this.certificationList.add(certification);
    }

    public List<Award> getAwardList() {
        return awardList;
    }

    public void addAward(Award award) {
        this.awardList.add(award);
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void addLanguage(Language language) {
        this.languageList.add(language);
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void addProject(Project project) {
        this.projectList.add(project);
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public void addPublication(Publication publication) {
        this.publicationList.add(publication);
    }
}
