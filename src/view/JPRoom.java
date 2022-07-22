package view;

import model.Room;

import javax.swing.*;
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
        this.setBorder(BorderFactory.createLineBorder(Color.red, 1, true));
        this.setLayout(new GridLayout(6, 1));

        this.jlID.setText(this.room.getRoomID());
        this.jlLarge.setText(String.valueOf(this.room.getLarge()));
        this.jlBed.setText(String.valueOf(this.room.getBed()));
        this.jlPrice.setText(String.valueOf(this.room.getPrice()));
        this.jlStatus.setText(this.room.getStatus());

        this.add(this.jlID);
        this.add(this.jlLarge);
        this.add(this.jlBed);
        this.add(this.jlPrice);
        this.add(this.jlStatus);
        this.add(jbBook);
    }
}
