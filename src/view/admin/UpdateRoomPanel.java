package view.admin;

import controller.admin.UpdateRoomListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UpdateRoomPanel extends JPanel {
    private final Font FONT_BORDER = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font FONT_LABEL = new Font("arial", Font.PLAIN, 16);
    private final Font FONT_BUTTON = new Font("Arial", Font.BOLD, 14);
    private JTextField iDTextField = new JTextField();
    private JTextField largeTextField = new JTextField();
    private JTextField bedTextField = new JTextField();
    private JTextField priceTextField = new JTextField();
    private JLabel iDLabel = new JLabel("ID: ");
    private JLabel largeLabel = new JLabel("Large: ");
    private JLabel priceLabel = new JLabel("Price: ");
    private JLabel bedLabel = new JLabel("Num of bed: ");
    private JButton editButton = new JButton("Edit");
    private JButton addButton = new JButton("Add");
    private JButton deleteButton = new JButton("Delete");
    private UpdateRoomListener updateRoomListener = new UpdateRoomListener(this);
    private final HotelManageFrame HM;

    public UpdateRoomPanel(HotelManageFrame HM) {
        this.HM = HM;
        this.setupBorder("Room");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
        this.add(iDLabel);
        this.add(iDTextField);

        this.add(largeLabel);
        this.add(largeTextField);

        this.add(bedLabel);
        this.add(bedTextField);

        this.add(priceLabel);
        this.add(priceTextField);

        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
    }

    private void setupComponent() {
        this.setupID();
        this.setupLarge();
        this.setupBed();
        this.setupPrice();
        this.setupJBAdd();
        this.setupJBEdit();
        this.setupJBDelete();
    }

    private void setupID() {
        iDLabel.setFont(FONT_LABEL);
        iDLabel.setForeground(Color.black);
        iDLabel.setBounds(15, 40,150,30);
        iDTextField.setBounds(110, 40,150,30);
    }

    private void setupLarge() {
        largeLabel.setFont(FONT_LABEL);
        largeLabel.setForeground(Color.black);
        largeLabel.setBounds(15, 85, 150,30);
        largeTextField.setBounds(110, 85,150,30);
    }

    private void setupBed() {
        bedLabel.setFont(FONT_LABEL);
        bedLabel.setForeground(Color.black);
        bedLabel.setBounds(15, 130,150,30);
        bedTextField.setBounds(110, 130, 150,30);
    }

    private void setupPrice() {
        priceLabel.setFont(FONT_LABEL);
        priceLabel.setForeground(Color.black);
        priceLabel.setBounds(15, 175, 150,30);
        priceTextField.setBounds(110, 175,150,30);
    }
    private void setupJBAdd() {
        addButton.setBackground(Color.yellow);
        addButton.setFont(FONT_BUTTON);
        addButton.setBounds(15, 240, 80,30);
        addButton.addActionListener(updateRoomListener);
    }

    private void setupJBEdit() {
        editButton.setBackground(Color.yellow);
        editButton.setFont(FONT_BUTTON);
        editButton.setBounds(107, 240,80,30);
        editButton.addActionListener(updateRoomListener);
    }

    private void setupJBDelete() {
        deleteButton.setBackground(Color.yellow);
        deleteButton.setFont(FONT_BUTTON);
        deleteButton.setBounds(200, 240,80,30);
        deleteButton.addActionListener(updateRoomListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FONT_BORDER));
    }

    public JTextField getiDTextField() {
        return iDTextField;
    }

    public JTextField getLargeTextField() {
        return largeTextField;
    }

    public JTextField getBedTextField() {
        return bedTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public HotelManageFrame getHM() {
        return HM;
    }
}