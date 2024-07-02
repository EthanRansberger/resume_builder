package com.resumebuilder.ui;

import com.itextpdf.text.DocumentException;
import com.resumebuilder.models.Person;
import com.resumebuilder.utils.PDFGenerator;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MainFrame extends JFrame {
    private Person person;

    private ContactInfoPanel contactInfoPanel;
    private SkillsPanel skillsPanel;
    private EducationPanel educationPanel;
    private CertificationsPanel certificationsPanel;
    private ProjectsPanel projectsPanel;
    private AwardsPanel awardsPanel;
    private PublicationsPanel publicationsPanel;
    private VolunteerPanel volunteerPanel;
    private JobsPanel jobsPanel;
    private LanguagesPanel languagesPanel;

    public MainFrame() {
        person = new Person();

        setTitle("Resume Builder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        contactInfoPanel = new ContactInfoPanel();
        skillsPanel = new SkillsPanel();
        educationPanel = new EducationPanel();
        certificationsPanel = new CertificationsPanel();
        projectsPanel = new ProjectsPanel();
        awardsPanel = new AwardsPanel();
        publicationsPanel = new PublicationsPanel();
        volunteerPanel = new VolunteerPanel();
        jobsPanel = new JobsPanel();
        languagesPanel = new LanguagesPanel();

        tabbedPane.addTab("Contact Info", contactInfoPanel);
        tabbedPane.addTab("Skills", skillsPanel);
        tabbedPane.addTab("Education", educationPanel);
        tabbedPane.addTab("Certifications", certificationsPanel);
        tabbedPane.addTab("Projects", projectsPanel);
        tabbedPane.addTab("Awards", awardsPanel);
        tabbedPane.addTab("Publications", publicationsPanel);
        tabbedPane.addTab("Volunteer", volunteerPanel);
        tabbedPane.addTab("Jobs", jobsPanel);
        tabbedPane.addTab("Languages", languagesPanel);

        add(tabbedPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save Resume");
        saveButton.addActionListener(e -> saveResume());
        JButton loadButton = new JButton("Load Resume");
        loadButton.addActionListener(e -> loadResume());
        JButton pdfButton = new JButton("Convert to PDF");
        pdfButton.addActionListener(e -> convertToPDF());

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(pdfButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveResume() {
        contactInfoPanel.saveData(person);
        skillsPanel.saveData(person);
        educationPanel.saveData(person);
        certificationsPanel.saveData(person);
        projectsPanel.saveData(person);
        awardsPanel.saveData(person);
        publicationsPanel.saveData(person);
        volunteerPanel.saveData(person);
        jobsPanel.saveData(person);
        languagesPanel.saveData(person);

        // Save logic...
    }

    private void loadResume() {
        // Load logic...

        contactInfoPanel.loadData(person);
        skillsPanel.loadData(person);
        educationPanel.loadData(person);
        certificationsPanel.loadData(person);
        projectsPanel.loadData(person);
        awardsPanel.loadData(person);
        publicationsPanel.loadData(person);
        volunteerPanel.loadData(person);
        jobsPanel.loadData(person);
        languagesPanel.loadData(person);
    }

    private void convertToPDF() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                PDFGenerator.generatePDF(person, file.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "PDF generated successfully!");
            } catch (FileNotFoundException | DocumentException e) {
                JOptionPane.showMessageDialog(this, "Error generating PDF: " + e.getMessage());
            }
        }
    }
}
