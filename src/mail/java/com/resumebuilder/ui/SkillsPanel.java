package com.resumebuilder.ui;

import com.resumebuilder.models.Person;
import com.resumebuilder.models.Skill;

import javax.swing.*;
import java.awt.*;

public class SkillsPanel extends JPanel {
    private JTextField skillField;
    private JCheckBox hardSkillCheckBox;
    private DefaultListModel<Skill> skillListModel;
    private JList<Skill> skillList;

    public SkillsPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(1, 3));
        skillField = new JTextField();
        inputPanel.add(skillField);
        hardSkillCheckBox = new JCheckBox("Hard Skill");
        inputPanel.add(hardSkillCheckBox);
        JButton addButton = new JButton("Add Skill");
        addButton.addActionListener(e -> addSkill());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        skillListModel = new DefaultListModel<>();
        skillList = new JList<>(skillListModel);
        add(new JScrollPane(skillList), BorderLayout.CENTER);
    }

    private void addSkill() {
        String skillName = skillField.getText();
        boolean isHardSkill = hardSkillCheckBox.isSelected();
        if (!skillName.isEmpty()) {
            Skill skill = new Skill(skillName, isHardSkill);
            skillListModel.addElement(skill);
            skillField.setText("");
            hardSkillCheckBox.setSelected(false);
        }
    }

    public void saveData(Person person) {
        person.getSkills().clear();
        for (int i = 0; i < skillListModel.size(); i++) {
            person.addSkill(skillListModel.get(i));
        }
    }

    public void loadData(Person person) {
        skillListModel.clear();
        for (Skill skill : person.getSkills()) {
            skillListModel.addElement(skill);
        }
    }
}
