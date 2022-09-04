package view.userView;

import model.input.ReadWriteRoom;
import model.entity.Room;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPService extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("times new roman", Font.BOLD, 20);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);
    private JLabel jlID, jlLarge, jlNOBed, jlPrice, jlStartDate;
    private Room room;
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();
    public JPService() {
        room = new Room("000", 0,0,0);
        this.setupBorder("Hotel service");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }
    public JPService(String name) {
        room = new Room("000", 0,0,0);
        for (Room r:readWriteRoom.getListRooms()) {
            if (r.getStatus().equals(name)) {
                room = r;
                break;
            }
        }
        this.setupBorder("Hotel service");
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
        jlID = new JLabel("ID: " + room.getRoomID());
        jlID.setBounds(40,50,300,40);
        jlID.setFont(jlFont);
    }
    private void setupJLLarge() {
        jlLarge = new JLabel("Large: " + room.getLarge() + " mv");
        jlLarge.setBounds(40,150,300,40);
        jlLarge.setFont(jlFont);
    }
    private void setupJLNOBed() {
        jlNOBed = new JLabel("Num of bed: " + room.getBed());
        jlNOBed.setBounds(40,250,300,40);
        jlNOBed.setFont(jlFont);
    }
    private void setupJLPrice() {
        jlPrice = new JLabel("Price: " + room.getPrice() + " VND/Day");
        jlPrice.setBounds(40,350,300,40);
        jlPrice.setFont(jlFont);
    }
    private void setupJLStartDate() {
        jlStartDate = new JLabel("Start: " + room.getStartDate());
        jlStartDate.setBounds(40,450,300,40);
        jlStartDate.setFont(jlFont);
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
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
