package view.admin;

import controller.admin.HotelManagerListener;
import view.login.Login;

import javax.swing.*;
import java.awt.*;

public class JFHotelManagement extends JFrame {
    static final int FRAME_WIDTH = 1200, FRAME_HIGH = 600;
    private final JPanel jpSideBar = new JPanel(new GridLayout(1, 2));
    private JPRoomManagement jpRoom = new JPRoomManagement();
    private final JPInformation jpInformation;
    private final JPUpdateRoom jpUpdateRoom = new JPUpdateRoom(this);
    private final JPUpdateAccount jpUpdateAccount = new JPUpdateAccount();
    private final String name;
    private final HotelManagerListener hotelManagerListener = new HotelManagerListener(this);
    public JFHotelManagement(String name) {
        this.name = name;
        this.jpInformation = new JPInformation(name);
        this.init();
    }

    public void init() {
        this.setTitle("Hotel Management.");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        this.setupComponent();
        this.addComponent();

        this.setVisible(true);
    }

    private void addComponent() {
        this.add(jpRoom);
        this.add(jpSideBar);
        this.add(jpInformation);
        this.add(jpUpdateAccount);
        this.add(jpUpdateRoom);
    }

    public void setupComponent () {
        jpRoom.setBounds(0, 0, 580, FRAME_HIGH*95/100);
        jpUpdateAccount.setBounds(579, 0, FRAME_WIDTH/4, FRAME_HIGH*43/100);
        jpUpdateRoom.setBounds(579, FRAME_HIGH*43/100, FRAME_WIDTH/4, FRAME_HIGH*50/100);
        jpInformation.setBounds(880, 0, 295, 558);
        jpInformation.getJbQuit().addActionListener(hotelManagerListener);
    }

    public void refreshRoom() {
        jpRoom.setVisible(false);
        jpRoom = new JPRoomManagement();
        jpRoom.setBounds(0, 0, 580, FRAME_HIGH*95/100);
        this.add(jpRoom);
    }

    public void quitApp() {
        jpInformation.getChatAdmin().setRun(false);
        jpInformation.getChatAdmin().closePort();
        new Login();
        this.dispose();
    }
}
