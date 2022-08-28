package view.adminManager;

import model.entity.Room;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JPRoom extends JPanel {
    private JLabel jlID = new JLabel("0");
    private JLabel jlLarge = new JLabel("0");
    private JLabel jlBed = new JLabel("0");
    private JLabel jlStatus = new JLabel("0");
    private JLabel jlPrice = new JLabel("0");
    private JButton jbBook = new JButton("Book");
    private Room room;

    public JPRoom (Room room) {
        this.room = room;
        this.init();
    }
    private void init() {
        Border border = BorderFactory.createLineBorder(Color.black, 1, true);
        Border border1 = BorderFactory.createEmptyBorder(10, 10,10,10);
        Border border2 = BorderFactory.createCompoundBorder(border, border1);
        this.setBorder(border2);
        this.setLayout(new GridLayout(6, 1));

        this.setupJButtonBook();
        this.showInfoRoom();
        this.updateStatusUI();

        this.add(this.jlID);
        this.add(this.jlLarge);
        this.add(this.jlBed);
        this.add(this.jlPrice);
        this.add(this.jlStatus);
        this.add(jbBook);
    }
    public void showInfoRoom() {
        this.jlID.setText("ID: " + room.getRoomID());
        this.jlLarge.setText(String.valueOf("Large: " + room.getLarge()));
        this.jlBed.setText(String.valueOf("Num of bed: " + room.getBed()));
        this.jlPrice.setText(String.valueOf("Price: " + room.getPrice()));
        this.jlStatus.setText(this.room.getStatus());
    }
    private void updateStatusUI() {
        if (room.getStatus().equals("Available")) {
            jlStatus.setForeground(Color.green);
        }
        else {
            jlStatus.setForeground(Color.red);
        }
    }
    public void setupJButtonBook () {
        jbBook.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        jbBook.setBackground(Color.gray);
    }
}
