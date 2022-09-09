package view.user;

import model.input.ReadWriteRoom;
import model.entity.Room;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ServicePanel extends JPanel {
    private final Font FONT_BORDER = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font FONT_LABEL = new Font("times new roman", Font.BOLD, 20);
    private JLabel IDLabel, largeLabel, nOBedLabel, priceLabel, startDateLabel;
    private Room room;
    private final ReadWriteRoom readWriteRoom = new ReadWriteRoom();

    public ServicePanel(String name) {
        room = new Room("000", 0,0,0);
        readWriteRoom.readListRooms();
        for (Room r:readWriteRoom.getListRooms()) {
            if (r.getStatus().equals(name)) {
                room = r;
                break;
            }
        }
        this.setupBorder("Room information");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void setupComponent() {
        this.setupIDLabel();
        this.setupLargeLabel();
        this.setupNOBedLabel();
        this.setupPriceLabel();
        this.setupStartDateLabel();
    }

    private void setupIDLabel() {
        IDLabel = new JLabel("Room ID: " + room.getRoomID());
        IDLabel.setBounds(40,50,300,40);
        IDLabel.setFont(FONT_LABEL);
    }

    private void setupLargeLabel() {
        largeLabel = new JLabel("Large: " + room.getLarge() + " m2");
        largeLabel.setBounds(40,150,300,40);
        largeLabel.setFont(FONT_LABEL);
    }

    private void setupNOBedLabel() {
        nOBedLabel = new JLabel("Num of bed: " + room.getBed());
        nOBedLabel.setBounds(40,250,300,40);
        nOBedLabel.setFont(FONT_LABEL);
    }

    private void setupPriceLabel() {
        priceLabel = new JLabel("Price: " + room.getPrice() + " VND/Day");
        priceLabel.setBounds(40,350,300,40);
        priceLabel.setFont(FONT_LABEL);
    }

    private void setupStartDateLabel() {
        startDateLabel = new JLabel("Start: " + room.getStartDate());
        startDateLabel.setBounds(40,450,300,40);
        startDateLabel.setFont(FONT_LABEL);
    }

    private void addComponent() {
        this.add(IDLabel);
        this.add(largeLabel);
        this.add(nOBedLabel);
        this.add(priceLabel);
        this.add(startDateLabel);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FONT_BORDER));
    }
}
