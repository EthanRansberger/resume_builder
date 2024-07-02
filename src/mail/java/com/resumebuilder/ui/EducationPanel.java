package com.resumebuilder.ui;

import com.resumebuilder.models.Education;
import com.resumebuilder.models.Person;

import javax.swing.*;
import java.awt.*;

public class EducationPanel extends JPanel {
    private JTextField degreeField;
    private JTextField majorField;
    private JTextField minorField;
    private JTextField institutionField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField additionalInfoField;
    private DefaultListModel<Education> educationListModel;
    private JList<Education> educationList;

    public EducationPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        inputPanel.add(new JLabel("Degree:"));
        degreeField = new JTextField();
        inputPanel.add(degreeField);

        inputPanel.add(new JLabel("Major:"));
        majorField = new JTextField();
        inputPanel.add(majorField);

        inputPanel.add(new JLabel("Minor:"));
        minorField = new JTextField();
        inputPanel.add(minorField);

        inputPanel.add(new JLabel("Institution:"));
        institutionField = new JTextField();
        inputPanel.add(institutionField);

        inputPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField();
        inputPanel.add(startDateField);

        inputPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField();
        inputPanel.add(endDateField);

        inputPanel.add(new JLabel("Additional Info:"));
        additionalInfoField = new JTextField();
        inputPanel.add(additionalInfoField);

        JButton addButton = new JButton("Add Education");
        addButton.addActionListener(e -> addEducation());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        educationListModel = new DefaultListModel<>();
        educationList = new JList<>(educationListModel);
        add(new JScrollPane(educationList), BorderLayout.CENTER);
    }

    private void addEducation() {
        String degree = degreeField.getText();
        String major = majorField.getText();
        String minor = minorField.getText();
        String institution = institutionField.getText();
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        String additionalInfo = additionalInfoField.getText();

        if (!degree.isEmpty() && !institution.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty()) {
            Education education = new Education(degree, major, minor, institution, startDate, endDate, additionalInfo);
            educationListModel.addElement(education);
            degreeField.setText("");
            majorField.setText("");
            minorField.setText("");
            institutionField.setText("");
            startDateField.setText("");
            endDateField.setText("");
            additionalInfoField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getEducationList().clear();
        for (int i = 0; i < educationListModel.size(); i++) {
            person.addEducation(educationListModel.get(i));
        }
    }

    public void loadData(Person person) {
        educationListModel.clear();
        for (Education education : person.getEducationList()) {
            educationListModel.addElement(education);
        }
    }
}
