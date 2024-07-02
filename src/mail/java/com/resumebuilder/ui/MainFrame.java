package com.resumebuilder;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ContactInfoPanel contactInfoPanel;
    private EducationPanel educationPanel;
    private JobsPanel jobsPanel;
    private LanguagesPanel languagesPanel;
    private ProjectsPanel projectsPanel;
    private CertificationsPanel certificationsPanel;
    private AwardsPanel awardsPanel;
    private SkillsPanel skillsPanel;
    private VolunteerPanel volunteerPanel;
    private PublicationsPanel publicationsPanel;

    public MainFrame() {
        setTitle("Resume Builder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize panels
        contactInfoPanel = new ContactInfoPanel();
        educationPanel = new EducationPanel();
        jobsPanel = new JobsPanel();
        languagesPanel = new LanguagesPanel();
        projectsPanel = new ProjectsPanel();
        certificationsPanel = new CertificationsPanel();
        awardsPanel = new AwardsPanel();
        skillsPanel = new SkillsPanel();
        volunteerPanel = new VolunteerPanel();
        publicationsPanel = new PublicationsPanel();

        // Add panels to the frame
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Contact Info", contactInfoPanel);
        tabbedPane.addTab("Education", educationPanel);
        tabbedPane.addTab("Jobs", jobsPanel);
        tabbedPane.addTab("Languages", languagesPanel);
        tabbedPane.addTab("Projects", projectsPanel);
        tabbedPane.addTab("Certifications", certificationsPanel);
        tabbedPane.addTab("Awards", awardsPanel);
        tabbedPane.addTab("Skills", skillsPanel);
        tabbedPane.addTab("Volunteer Work", volunteerPanel);
        tabbedPane.addTab("Publications", publicationsPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
