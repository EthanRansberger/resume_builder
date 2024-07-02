package com.resumebuilder.utils;

import com.resumebuilder.models.Person;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PDFGenerator {
    public static void generateResume(Person person, String filePath) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 725);

            // Contact Info
            contentStream.showText("Name: " + person.getName());
            contentStream.newLine();
            contentStream.showText("Phone: " + person.getPhone());
            contentStream.newLine();
            contentStream.showText("Email: " + person.getEmail());
            contentStream.newLine();
            contentStream.showText("LinkedIn: " + person.getLinkedin());
            contentStream.newLine();
            contentStream.showText("Repository: " + person.getRepo());
            contentStream.newLine();
            contentStream.showText("Address: " + person.getAddress());
            contentStream.newLine();
            contentStream.newLine();

            // Education
            contentStream.showText("Education:");
            contentStream.newLine();
            for (var edu : person.getEducationList()) {
                contentStream.showText(edu.getDegree() + " in " + edu.getMajor() + " from " + edu.getInstitution());
                contentStream.newLine();
                contentStream.showText("Minor: " + edu.getMinor());
                contentStream.newLine();
                contentStream.showText("Duration: " + edu.getStartDate() + " - " + edu.getEndDate());
                contentStream.newLine();
                contentStream.showText("Additional Info: " + edu.getAdditionalInfo());
                contentStream.newLine();
                contentStream.newLine();
            }

            // Experience
            contentStream.showText("Experience:");
            contentStream.newLine();
            for (var exp : person.getExperienceList()) {
                contentStream.showText(exp.getTitle() + " at " + exp.getCompany());
                contentStream.newLine();
                contentStream.showText("Duration: " + exp.getStartDate() + " - " + exp.getEndDate());
                contentStream.newLine();
                contentStream.showText(exp.getDescription());
                contentStream.newLine();
                contentStream.newLine();
            }

            // Skills
            contentStream.showText("Skills:");
            contentStream.newLine();
            for (var skill : person.getSkillList()) {
                contentStream.showText((skill.isHardSkill() ? "Hard Skill: " : "Soft Skill: ") + skill.getName());
                contentStream.newLine();
            }
            contentStream.newLine();

            // Certifications
            contentStream.showText("Certifications:");
            contentStream.newLine();
            for (var cert : person.getCertificationList()) {
                contentStream.showText(cert.getName() + " by " + cert.getIssuingOrganization());
                contentStream.newLine();
                contentStream.showText("Issued: " + cert.getIssueDate() + " Expires: " + cert.getExpirationDate());
                contentStream.newLine();
                contentStream.newLine();
            }

            // Awards
            contentStream.showText("Awards:");
            contentStream.newLine();
            for (var award : person.getAwardList()) {
                contentStream.showText(award.getTitle() + ": " + award.getDescription());
                contentStream.newLine();
                contentStream.newLine();
            }

            // Languages
            contentStream.showText("Languages:");
            contentStream.newLine();
            for (var lang : person.getLanguageList()) {
                contentStream.showText(lang.getName() + " (" + lang.getProficiency() + ")");
                contentStream.newLine();
            }
            contentStream.newLine();

            // Projects
            contentStream.showText("Projects:");
            contentStream.newLine();
            for (var proj : person.getProjectList()) {
                contentStream.showText(proj.getTitle());
                contentStream.newLine();
                contentStream.showText(proj.getDescription());
                contentStream.newLine();
                contentStream.showText("Technologies: " + proj.getTechnologies());
                contentStream.newLine();
                contentStream.showText("Duration: " + proj.getStartDate() + " - " + proj.getEndDate());
                contentStream.newLine();
                contentStream.newLine();
            }

            // Publications
            contentStream.showText("Publications:");
            contentStream.newLine();
            for (var pub : person.getPublicationList()) {
                contentStream.showText(pub.getTitle() + " by " + pub.getPublisher());
                contentStream.newLine();
                contentStream.showText("Published on: " + pub.getPublicationDate());
                contentStream.newLine();
                contentStream.showText(pub.getDescription());
                contentStream.newLine();
                contentStream.newLine();
            }

            contentStream.endText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            document.save(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
