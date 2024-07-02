package com.resumebuilder.ui;

import com.resumebuilder.models.Language;
import com.resumebuilder.models.Person;

import javax.swing.*;
import java.awt.*;

public class LanguagesPanel extends JPanel {
    private JTextField nameField;
    private JTextField proficiencyField;
    private DefaultListModel<Language> languageListModel;
    private JList<Language> languageList;

    public LanguagesPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Language:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Proficiency:"));
        proficiencyField = new JTextField();
        inputPanel.add(proficiencyField);

        JButton addButton = new JButton("Add Language");
        addButton.addActionListener(e -> addLanguage());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        languageListModel = new DefaultListModel<>();
        languageList = new JList<>(languageListModel);
        add(new JScrollPane(languageList), BorderLayout.CENTER);
    }

    private void addLanguage() {
        String name = nameField.getText();
        String proficiency = proficiencyField.getText();

        if (!name.isEmpty() && !proficiency.isEmpty()) {
            Language language = new Language(name, proficiency);
            languageListModel.addElement(language);
            nameField.setText("");
            proficiencyField.setText("");
        }
    }

    public void saveData(Person person) {
        person.getLanguages().clear();
        for (int i = 0; i < languageListModel.size(); i++) {
            person.addLanguage(languageListModel.get(i));
        }
    }

    public void loadData(Person person) {
        languageListModel.clear();
        for (Language language : person.getLanguages()) {
            languageListModel.addElement(language);
        }
    }
}
