package com.resumebuilder.ui;

import com.resumebuilder.models.Person;
import com.resumebuilder.models.Project;

import javax.swing.*;
import java.awt.*;

public class ProjectsPanel extends JPanel {
    private JTextField titleField;
    private JTextField descriptionField;
    private JTextField technologiesField;
    private JTextField startDateField;
    private JTextField endDateField;
    private DefaultListModel<Project> projectListModel;
    private JList<Project> projectList;

    public ProjectsPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Technologies:"));
        technologiesField = new JTextField();
        inputPanel.add(technologiesField);

        inputPanel.add(new JLabel("Start Date:"));
        startDateField = new JTextField();
        inputPanel.add(startDateField);

        inputPanel.add(new JLabel("End Date:"));
        endDateField = new JTextField();
        inputPanel.add(endDateField);

        JButton addButton = new JButton("Add Project");
        addButton.addActionListener(e -> addProject());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        projectListModel = new DefaultListModel<>();
        projectList = new JList<>(projectListModel);
        add(new JScrollPane(projectList), BorderLayout.CENTER);
    }

    private void addProject() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        String technologies = technologiesField.getText();
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();

        if (!title.isEmpty() && !description.isEmpty() && !technologies.isEmpty() && !startDate.isEmpty() && !endDate.isEmpty()) {
            Project project = new Project(title, description, technologies, startDate, endDate);
            projectListModel.addElement(project);
            titleField.setText("");
            descriptionField.setText("");
            technologiesField.setText("");
            startDateField.setText("");
            endDateField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getProjects().clear();
        for (int i = 0; i < projectListModel.size(); i++) {
            person.addProject(projectListModel.get(i));
        }
    }

    public void loadData(Person person) {
        projectListModel.clear();
        for (Project project : person.getProjects()) {
            projectListModel.addElement(project);
        }
    }
}
