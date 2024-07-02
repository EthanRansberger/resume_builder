package com.resumebuilder.ui;

import com.resumebuilder.models.Person;
import com.resumebuilder.models.Publication;

import javax.swing.*;
import java.awt.*;

public class PublicationsPanel extends JPanel {
    private JTextField titleField;
    private JTextField journalField;
    private JTextField dateField;
    private JTextField descriptionField;
    private DefaultListModel<Publication> publicationListModel;
    private JList<Publication> publicationList;

    public PublicationsPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Journal:"));
        journalField = new JTextField();
        inputPanel.add(journalField);

        inputPanel.add(new JLabel("Date:"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        JButton addButton = new JButton("Add Publication");
        addButton.addActionListener(e -> addPublication());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        publicationListModel = new DefaultListModel<>();
        publicationList = new JList<>(publicationListModel);
        add(new JScrollPane(publicationList), BorderLayout.CENTER);
    }

    private void addPublication() {
        String title = titleField.getText();
        String journal = journalField.getText();
        String date = dateField.getText();
        String description = descriptionField.getText();

        if (!title.isEmpty() && !journal.isEmpty() && !date.isEmpty() && !description.isEmpty()) {
            Publication publication = new Publication(title, journal, date, description);
            publicationListModel.addElement(publication);
            titleField.setText("");
            journalField.setText("");
            dateField.setText("");
            descriptionField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getPublications().clear();
        for (int i = 0; i < publicationListModel.size(); i++) {
            person.addPublication(publicationListModel.get(i));
        }
    }

    public void loadData(Person person) {
        publicationListModel.clear();
        for (Publication publication : person.getPublications()) {
            publicationListModel.addElement(publication);
        }
    }
}
