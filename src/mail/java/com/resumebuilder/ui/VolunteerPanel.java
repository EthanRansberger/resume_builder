package com.resumebuilder.ui;

import com.resumebuilder.models.Person;
import com.resumebuilder.models.VolunteerExperience;

import javax.swing.*;
import java.awt.*;

public class VolunteerPanel extends JPanel {
    private JTextField roleField;
    private JTextField organizationField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField descriptionField;
    private DefaultListModel<VolunteerExperience> volunteerListModel;
    private JList<VolunteerExperience> volunteerList;

    public VolunteerPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Role:"));
        roleField = new JTextField();
        inputPanel.add(roleField);

        inputPanel.add(new JLabel("Organization:"));
        organizationField = new JTextField();
        inputPanel.add(organizationField);

        inputPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField();
        inputPanel.add(startDateField);

        inputPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField();
        inputPanel.add(endDateField);

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        JButton addButton = new JButton("Add Volunteer Experience");
        addButton.addActionListener(e -> addVolunteerExperience());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        volunteerListModel = new DefaultListModel<>();
        volunteerList = new JList<>(volunteerListModel);
        add(new JScrollPane(volunteerList), BorderLayout.CENTER);
    }

    private void addVolunteerExperience() {
        String role = roleField.getText();
        String organization = organizationField.getText();
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();
        String description = descriptionField.getText();

        if (!role.isEmpty() && !organization.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty() && !description.isEmpty()) {
            VolunteerExperience volunteerExperience = new VolunteerExperience(role, organization, startDate, endDate, description);
            volunteerListModel.addElement(volunteerExperience);
            roleField.setText("");
            organizationField.setText("");
            startDateField.setText("");
            endDateField.setText("");
            descriptionField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getVolunteerExperiences().clear();
        for (int i = 0; i < volunteerListModel.size(); i++) {
            person.addVolunteerExperience(volunteerListModel.get(i));
        }
    }

    public void loadData(Person person) {
        volunteerListModel.clear();
        for (VolunteerExperience volunteerExperience : person.getVolunteerExperiences()) {
            volunteerListModel.addElement(volunteerExperience);
        }
    }
}
