package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HotelManagement extends JFrame {
    private JPanel jpRoom, jpUser, jpInfo;
    static final int FRAME_WIDTH = 900, FRAME_HIGH = 600;

    public HotelManagement() {
        this.init();
    }

    public void init() {
        this.setTitle("Hotel Management.");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridLayout(1, 3));

        this.setupJPRooms();
        this.setupJPEmployees();
        this.setupJPInfo();

        this.add(jpRoom);
        this.add(jpUser);
        this.add(jpInfo);

        this.setVisible(true);
    }

    private void setupJPRooms () {
        jpRoom = new JPanel();
    }

    private void setupJPEmployees () {
        jpUser = new JPanel();
    }

    private void setupJPInfo () {
        jpInfo = new JPanel();
    }
}
