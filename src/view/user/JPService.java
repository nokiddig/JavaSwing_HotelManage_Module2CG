package view.user;

import model.input.ReadWriteRoom;
import model.entity.Room;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPService extends JPanel {
    private final Font FONT_BORDER = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font FONT_LABEL = new Font("times new roman", Font.BOLD, 20);
    private JLabel jlID, jlLarge, jlNOBed, jlPrice, jlStartDate;
    private Room room;
    private final ReadWriteRoom readWriteRoom = new ReadWriteRoom();

    public JPService(String name) {
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
        this.setupJLID();
        this.setupJLLarge();
        this.setupJLNOBed();
        this.setupJLPrice();
        this.setupJLStartDate();
    }

    private void setupJLID() {
        jlID = new JLabel("Room ID: " + room.getRoomID());
        jlID.setBounds(40,50,300,40);
        jlID.setFont(FONT_LABEL);
    }

    private void setupJLLarge() {
        jlLarge = new JLabel("Large: " + room.getLarge() + " m2");
        jlLarge.setBounds(40,150,300,40);
        jlLarge.setFont(FONT_LABEL);
    }

    private void setupJLNOBed() {
        jlNOBed = new JLabel("Num of bed: " + room.getBed());
        jlNOBed.setBounds(40,250,300,40);
        jlNOBed.setFont(FONT_LABEL);
    }

    private void setupJLPrice() {
        jlPrice = new JLabel("Price: " + room.getPrice() + " VND/Day");
        jlPrice.setBounds(40,350,300,40);
        jlPrice.setFont(FONT_LABEL);
    }

    private void setupJLStartDate() {
        jlStartDate = new JLabel("Start: " + room.getStartDate());
        jlStartDate.setBounds(40,450,300,40);
        jlStartDate.setFont(FONT_LABEL);
    }

    private void addComponent() {
        this.add(jlID);
        this.add(jlLarge);
        this.add(jlNOBed);
        this.add(jlPrice);
        this.add(jlStartDate);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FONT_BORDER));
    }
}
