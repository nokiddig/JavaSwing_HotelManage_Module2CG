package view.admin;

import controller.admin.UpdateAccountListener;
import model.entity.FontStyle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UpdateAccountPanel extends JPanel {
    private final JTextField nameTextField = new JTextField();
    private final JTextField passwordTextField = new JTextField();
    private final JLabel nameLabel = new JLabel("Username: ");
    private final JLabel passwordLabel = new JLabel("Password: ");
    private final JLabel statusLabel = new JLabel();
    private final JButton editButton = new JButton("Edit");
    private final JButton addButton = new JButton("Add");
    private final JButton deleteButton = new JButton("Delete");
    private final JRadioButton adminRadioButton = new JRadioButton("Admin");
    private final JRadioButton userRadioButton = new JRadioButton("User");
    private final UpdateAccountListener updateAccountListener = new UpdateAccountListener(this);

    public UpdateAccountPanel() {
        this.setupBorder("Account");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
        this.add(nameLabel);
        this.add(nameTextField);
        this.add(passwordLabel);
        this.add(passwordTextField);
        this.add(statusLabel);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
        this.add(adminRadioButton);
        this.add(userRadioButton);
    }

    private void setupComponent() {
        this.setupName();
        this.setupPass();
        this.setupRadioButton();
        this.setupJLStatus();
        this.setupAddButton();
        this.setupEditButton();
        this.setupDeleteButton();
    }

    private void setupName() {
        nameLabel.setFont(FontStyle.FONT_LABEL.getFont());
        nameLabel.setForeground(Color.black);
        nameLabel.setBounds(15, 60,150, 30);

        nameTextField.setBounds(100, 60,150, 30);
    }

    private void setupPass() {
        passwordLabel.setFont(FontStyle.FONT_LABEL.getFont());
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(15, 120, 150, 30);

        passwordTextField.setBounds(100, 120, 150, 30);
    }

    private void setupRadioButton() {
        adminRadioButton.setBounds(60, 165, 80,20);
        userRadioButton.setBounds(150, 165,80, 20);

        ButtonGroup bgTypeAcc = new ButtonGroup();
        bgTypeAcc.add(adminRadioButton);
        bgTypeAcc.add(userRadioButton);
    }

    private void setupJLStatus() {
        statusLabel.setForeground(Color.red);
        statusLabel.setFont(new Font("arial", Font.ITALIC, 12));
        statusLabel.setBounds(30, 180,200, 30);
    }

    private void setupAddButton() {
        addButton.setBackground(Color.yellow);
        addButton.setFont(FontStyle.FONT_BUTTON.getFont());
        addButton.setBounds(15, 210, 80, 30);
        addButton.addActionListener(updateAccountListener);
    }

    private void setupEditButton() {
        editButton.setBackground(Color.yellow);
        editButton.setFont(FontStyle.FONT_BUTTON.getFont());
        editButton.setBounds(107, 210,80, 30);
        editButton.addActionListener(updateAccountListener);
    }

    private void setupDeleteButton() {
        deleteButton.setBackground(Color.yellow);
        deleteButton.setFont(FontStyle.FONT_BUTTON.getFont());
        deleteButton.setBounds(200, 210,80, 30);
        deleteButton.addActionListener(updateAccountListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FontStyle.FONT_BORDER.getFont()));
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public JRadioButton getAdminRadioButton() {
        return adminRadioButton;
    }
}
