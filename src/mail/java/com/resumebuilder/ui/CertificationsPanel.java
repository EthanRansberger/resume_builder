package com.resumebuilder.ui;

import com.resumebuilder.models.Certification;
import com.resumebuilder.models.Person;

import javax.swing.*;
import java.awt.*;

public class CertificationsPanel extends JPanel {
    private JTextField nameField;
    private JTextField issuingOrgField;
    private JTextField issueDateField;
    private JTextField expirationDateField;
    private DefaultListModel<Certification> certificationListModel;
    private JList<Certification> certificationList;

    public CertificationsPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Issuing Organization:"));
        issuingOrgField = new JTextField();
        inputPanel.add(issuingOrgField);

        inputPanel.add(new JLabel("Issue Date:"));
        issueDateField = new JTextField();
        inputPanel.add(issueDateField);

        inputPanel.add(new JLabel("Expiration Date:"));
        expirationDateField = new JTextField();
        inputPanel.add(expirationDateField);

        JButton addButton = new JButton("Add Certification");
        addButton.addActionListener(e -> addCertification());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        certificationListModel = new DefaultListModel<>();
        certificationList = new JList<>(certificationListModel);
        add(new JScrollPane(certificationList), BorderLayout.CENTER);
    }

    private void addCertification() {
        String name = nameField.getText();
        String issuingOrg = issuingOrgField.getText();
        String issueDate = issueDateField.getText();
        String expirationDate = expirationDateField.getText();

        if (!name.isEmpty() && !issuingOrg.isEmpty() && !issueDate.isEmpty()) {
            Certification certification = new Certification(name, issuingOrg, issueDate, expirationDate);
            certificationListModel.addElement(certification);
            nameField.setText("");
            issuingOrgField.setText("");
            issueDateField.setText("");
            expirationDateField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getCertifications().clear();
        for (int i = 0; i < certificationListModel.size(); i++) {
            person.addCertification(certificationListModel.get(i));
        }
    }

    public void loadData(Person person) {
        certificationListModel.clear();
        for (Certification certification : person.getCertifications()) {
            certificationListModel.addElement(certification);
        }
    }
}
