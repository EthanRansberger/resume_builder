package com.resumebuilder.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.resumebuilder.models.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDFGenerator {
    public static void generatePDF(Person person, String filePath) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Add content to PDF
        addContactInfo(document, person);
        addSkills(document, person);
        addEducation(document, person);
        addExperiences(document, person);
        addCertifications(document, person);
        addAwards(document, person);
        addProjects(document, person);
        addPublications(document, person);
        addVolunteerExperiences(document, person);
        addLanguages(document, person);

        document.close();
    }

    private static void addContactInfo(Document document, Person person) throws DocumentException {
        // Add contact info
        Paragraph contactInfo = new Paragraph("Contact Information");
        contactInfo.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        contactInfo.setAlignment(Element.ALIGN_CENTER);
        document.add(contactInfo);

        document.add(new Paragraph("Name: " + person.getName()));
        document.add(new Paragraph("Phone: " + person.getPhoneNumber()));
        document.add(new Paragraph("Email: " + person.getEmail()));
        document.add(new Paragraph("LinkedIn: " + person.getLinkedIn()));
        document.add(new Paragraph("Repository: " + person.getRepositoryLink()));
        document.add(new Paragraph("Address: " + person.getAddress()));
        document.add(new Paragraph(" "));
    }

    private static void addSkills(Document document, Person person) throws DocumentException {
        // Add skills
        Paragraph skills = new Paragraph("Skills");
        skills.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        skills.setAlignment(Element.ALIGN_CENTER);
        document.add(skills);

        for (Skill skill : person.getSkills()) {
            document.add(new Paragraph(skill.getName() + (skill.isHardSkill() ? " (Hard Skill)" : " (Soft Skill)")));
        }
        document.add(new Paragraph(" "));
    }

    private static void addEducation(Document document, Person person) throws DocumentException {
        // Add education
        Paragraph education = new Paragraph("Education");
        education.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        education.setAlignment(Element.ALIGN_CENTER);
        document.add(education);

        for (Education edu : person.getEducationList()) {
            document.add(new Paragraph(edu.getDegree() + " in " + edu.getMajor() + " from " + edu.getInstitution() + " (" + edu.getStartDate() + " to " + edu.getEndDate() + ")"));
            document.add(new Paragraph("Minor: " + edu.getMinor()));
            document.add(new Paragraph("Additional Info: " + edu.getAdditionalInfo()));
        }
        document.add(new Paragraph(" "));
    }

    private static void addExperiences(Document document, Person person) throws DocumentException {
        // Add experiences
        Paragraph experiences = new Paragraph("Experiences");
        experiences.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        experiences.setAlignment(Element.ALIGN_CENTER);
        document.add(experiences);

        for (Experience exp : person.getExperiences()) {
            document.add(new Paragraph(exp.getTitle() + " at " + exp.getCompany() + " (" + exp.getStartDate() + " to " + exp.getEndDate() + ")"));
            document.add(new Paragraph("Description: " + exp.getDescription()));
        }
        document.add(new Paragraph(" "));
    }

    private static void addCertifications(Document document, Person person) throws DocumentException {
        // Add certifications
        Paragraph certifications = new Paragraph("Certifications");
        certifications.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        certifications.setAlignment(Element.ALIGN_CENTER);
        document.add(certifications);

        for (Certification cert : person.getCertifications()) {
            document.add(new Paragraph(cert.getName() + " from " + cert.getIssuingOrg() + " (Issued: " + cert.getIssueDate() + (cert.getExpirationDate() != null ? ", Expires: " + cert.getExpirationDate() : "") + ")"));
        }
        document.add(new Paragraph(" "));
    }

    private static void addAwards(Document document, Person person) throws DocumentException {
        // Add awards
        Paragraph awards = new Paragraph("Awards");
        awards.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        awards.setAlignment(Element.ALIGN_CENTER);
        document.add(awards);

        for (Award award : person.getAwards()) {
            document.add(new Paragraph(award.getName() + " (" + award.getDate() + ")"));
            document.add(new Paragraph("Description: " + award.getDescription()));
        }
        document.add(new Paragraph(" "));
    }

    private static void addProjects(Document document, Person person) throws DocumentException {
        // Add projects
        Paragraph projects = new Paragraph("Projects");
        projects.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        projects.setAlignment(Element.ALIGN_CENTER);
        document.add(projects);

        for (Project project : person.getProjects()) {
            document.add(new Paragraph(project.getTitle() + " (" + project.getStartDate() + " to " + project.getEndDate() + ")"));
            document.add(new Paragraph("Description: " + project.getDescription()));
            document.add(new Paragraph("Technologies: " + project.getTechnologies()));
        }
        document.add(new Paragraph(" "));
    }

    private static void addPublications(Document document, Person person) throws DocumentException {
        // Add publications
        Paragraph publications = new Paragraph("Publications");
        publications.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        publications.setAlignment(Element.ALIGN_CENTER);
        document.add(publications);

        for (Publication pub : person.getPublications()) {
            document.add(new Paragraph(pub.getTitle() + " in " + pub.getJournal() + " (" + pub.getDate() + ")"));
            document.add(new Paragraph("Description: " + pub.getDescription()));
        }
        document.add(new Paragraph(" "));
    }

    private static void addVolunteerExperiences(Document document, Person person) throws DocumentException {
        // Add volunteer experiences
        Paragraph volunteerExperiences = new Paragraph("Volunteer Experiences");
        volunteerExperiences.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        volunteerExperiences.setAlignment(Element.ALIGN_CENTER);
        document.add(volunteerExperiences);

        for (VolunteerExperience vol : person.getVolunteerExperiences()) {
            document.add(new Paragraph(vol.getRole() + " at " + vol.getOrganization() + " (" + vol.getStartDate() + " to " + vol.getEndDate() + ")"));
            document.add(new Paragraph("Description: " + vol.getDescription()));
        }
        document.add(new Paragraph(" "));
    }

    private static void addLanguages(Document document, Person person) throws DocumentException {
        // Add languages
        Paragraph languages = new Paragraph("Languages");
        languages.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
        languages.setAlignment(Element.ALIGN_CENTER);
        document.add(languages);

        for (Language lang : person.getLanguages()) {
            document.add(new Paragraph(lang.getName() + ": " + lang.getProficiency()));
        }
        document.add(new Paragraph(" "));
    }
}
