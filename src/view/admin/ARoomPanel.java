package view.admin;

import controller.admin.RoomListener;

import model.entity.Room;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ARoomPanel extends JPanel {
    private JLabel iDLabel, largeLabel, bedLabel, statusLabel, priceLabel;
    private JButton bookButton;
    private Room room;
    private RoomListener roomListener;

    public ARoomPanel(Room room) {
        this.room = room;
        this.initializeComponent();
        this.init();
    }

    private void initializeComponent() {
        iDLabel = new JLabel("0");
        largeLabel = new JLabel("0");
        bedLabel = new JLabel("0");
        statusLabel = new JLabel("0");
        priceLabel = new JLabel("0");
        bookButton = new JButton("Book");
        roomListener = new RoomListener(this);
    }

    private void init() {
        this.setupBorder();
        this.setLayout(new GridLayout(6, 1));

        this.setupBookButton();
        this.showRoomInformation();
        this.addComponent();
    }

    private void setupBorder() {
        Border border = BorderFactory.createLineBorder(Color.black, 1, true);
        Border border1 = BorderFactory.createEmptyBorder(10, 10,10,10);
        Border border2 = BorderFactory.createCompoundBorder(border, border1);
        this.setBorder(border2);
    }

    private void addComponent() {
        this.add(this.iDLabel);
        this.add(this.largeLabel);
        this.add(this.bedLabel);
        this.add(this.priceLabel);
        this.add(this.statusLabel);
        this.add(bookButton);
    }

    public void showRoomInformation() {
        this.iDLabel.setText("ID: " + room.getRoomID());
        this.largeLabel.setText("Large: " + room.getLarge());
        this.bedLabel.setText("Num of bed: " + room.getBed());
        this.priceLabel.setText("Price: " + room.getPrice());
        this.statusLabel.setText(this.room.getStatus());
        statusLabel.setForeground(room.getStatus().equals("Available")?Color.green:Color.red);
    }

    public void updateStatusUI() {
        if (!room.getStatus().equals("Available")) {
            statusLabel.setText(room.getStatus());
            statusLabel.setForeground(Color.red);
            bookButton.setText("Payment");
        }
        else {
            statusLabel.setText("Available");
            statusLabel.setForeground(Color.green);
            bookButton.setText("Book");
        }
    }

    public void setupBookButton() {
        bookButton.setBackground(Color.orange);
        bookButton.addActionListener(roomListener);
        this.updateStatusUI();
    }

    public Room getRoom() {
        return room;
    }
}
