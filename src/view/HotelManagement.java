package view;

import model.Room;
import model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class HotelManagement extends JFrame {
    static final int FRAME_WIDTH = 1200, FRAME_HIGH = 600;
    private JPanel jpRight, jpInfo;
    private roomManagement jpRoom;
    private userManagement jpUser;

    public HotelManagement() {
        this.init();
    }

    public void init() {
        this.setTitle("Hotel Management.");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2));

        this.jpRoom = new roomManagement();
        this.setupJPRight();

        this.add(jpRoom);
        this.add(jpRight);

        this.setVisible(true);
    }

    private void setupJPRight() {
        jpRight = new JPanel(new GridLayout(1, 2));

        jpUser = new userManagement();
        jpInfo = new JPanel();
        jpInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jpRight.add(jpUser);
        jpRight.add(jpInfo);
    }

    public static void main(String[] args) {
        new HotelManagement();
    }
}
