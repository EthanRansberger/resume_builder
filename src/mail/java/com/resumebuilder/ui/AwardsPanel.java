package com.resumebuilder.ui;

import com.resumebuilder.models.Award;
import com.resumebuilder.models.Person;

import javax.swing.*;
import java.awt.*;

public class AwardsPanel extends JPanel {
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField dateField;
    private DefaultListModel<Award> awardListModel;
    private JList<Award> awardList;

    public AwardsPanel() {
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        inputPanel.add(descriptionField);

        inputPanel.add(new JLabel("Date:"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        JButton addButton = new JButton("Add Award");
        addButton.addActionListener(e -> addAward());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // List model and JList for displaying awards
        awardListModel = new DefaultListModel<>();
        awardList = new JList<>(awardListModel);
        awardList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(awardList), BorderLayout.CENTER);

        // Context menu for editing and deleting items
        JPopupMenu contextMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("Edit");
        editItem.addActionListener(e -> editSelectedAward());
        contextMenu.add(editItem);

        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(e -> deleteSelectedAward());
        contextMenu.add(deleteItem);

        awardList.setComponentPopupMenu(contextMenu);
        awardList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    awardList.setSelectedIndex(awardList.locationToIndex(evt.getPoint()));
                }
            }
        });
    }

    private void addAward() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        String date = dateField.getText();

        if (!name.isEmpty() && !description.isEmpty() && !date.isEmpty()) {
            Award award = new Award(name, description, date);
            awardListModel.addElement(award);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editSelectedAward() {
        int selectedIndex = awardList.getSelectedIndex();
        if (selectedIndex != -1) {
            Award selectedAward = awardListModel.getElementAt(selectedIndex);
            nameField.setText(selectedAward.getName());
            descriptionField.setText(selectedAward.getDescription());
            dateField.setText(selectedAward.getDate());
            awardListModel.remove(selectedIndex);
        }
    }

    private void deleteSelectedAward() {
        int selectedIndex = awardList.getSelectedIndex();
        if (selectedIndex != -1) {
            awardListModel.remove(selectedIndex);
        }
    }

    private void clearFields() {
        nameField.setText("");
        descriptionField.setText("");
        dateField.setText("");
    }

    public void saveData(Person person) {
        person.getAwards().clear();
        for (int i = 0; i < awardListModel.size(); i++) {
            person.addAward(awardListModel.getElementAt(i));
        }
    }

    public void loadData(Person person) {
        awardListModel.clear();
        for (Award award : person.getAwards()) {
            awardListModel.addElement(award);
        }
    }
}
