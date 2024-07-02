package com.resumebuilder.ui;

import com.resumebuilder.models.Person;

import javax.swing.*;
import java.awt.*;

public class ContactInfoPanel extends JPanel {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField linkedInField;
    private JTextField repoField;
    private JTextField addressField;

    public ContactInfoPanel() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("LinkedIn:"));
        linkedInField = new JTextField();
        add(linkedInField);

        add(new JLabel("Repository Link:"));
        repoField = new JTextField();
        add(repoField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);
    }

    public void saveData(Person person) {
        person.setName(nameField.getText());
        person.setPhoneNumber(phoneField.getText());
        person.setEmail(emailField.getText());
        person.setLinkedIn(linkedInField.getText());
        person.setRepositoryLink(repoField.getText());
        person.setAddress(addressField.getText());
    }

    public void loadData(Person person) {
        nameField.setText(person.getName());
        phoneField.setText(person.getPhoneNumber());
        emailField.setText(person.getEmail());
        linkedInField.setText(person.getLinkedIn());
        repoField.setText(person.getRepositoryLink());
        addressField.setText(person.getAddress());
    }
}
