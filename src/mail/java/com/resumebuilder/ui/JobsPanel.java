package com.resumebuilder.ui;

import com.resumebuilder.models.Experience;
import com.resumebuilder.models.Person;

import javax.swing.*;
import java.awt.*;

public class JobsPanel extends JPanel {
    private JTextField titleField;
    private JTextField companyField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField descriptionField;
    private DefaultListModel<Experience> jobListModel;
    private JList<Experience> jobList;

    public JobsPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Company:"));
        companyField = new JTextField();
        inputPanel.add(companyField);

        inputPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField();
        inputPanel.add(startDateField);

        inputPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField();
        inputPanel.add(endDateField);

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        JButton addButton = new JButton("Add Job");
        addButton.addActionListener(e -> addJob());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        jobListModel = new DefaultListModel<>();
        jobList = new JList<>(jobListModel);
        add(new JScrollPane(jobList), BorderLayout.CENTER);
    }

    private void addJob() {
        String title = titleField.getText();
        String company = companyField.getText();
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        String description = descriptionField.getText();

        if (!title.isEmpty() && !company.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty() && !description.isEmpty()) {
            Experience job = new Experience(title, company, startDate, endDate, description);
            jobListModel.addElement(job);
            titleField.setText("");
            companyField.setText("");
            startDateField.setText("");
            endDateField.setText("");
            descriptionField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getExperiences().clear();
        for (int i = 0; i < jobListModel.size(); i++) {
            person.addExperience(jobListModel.get(i));
        }
    }

    public void loadData(Person person) {
        jobListModel.clear();
        for (Experience job : person.getExperiences()) {
            jobListModel.addElement(job);
        }
    }
}
