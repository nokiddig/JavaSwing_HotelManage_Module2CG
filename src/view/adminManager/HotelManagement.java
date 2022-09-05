package view.adminManager;

import controller.HotelManagerListener;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;

public class HotelManagement extends JFrame {
    static final int FRAME_WIDTH = 1200, FRAME_HIGH = 600;
    private JPanel jpSideBar = new JPanel(new GridLayout(1, 2));
    private RoomManagement jpRoom = new RoomManagement();
    private JPInformation jpInformation;
    private JPUpdateRoom jpUpdateRoom = new JPUpdateRoom(this);
    private JPUpdateAccount jpUpdateAccount = new JPUpdateAccount();
    private String name;
    private HotelManagerListener hotelManagerListener = new HotelManagerListener(this);
    public HotelManagement(String name) {
        this.name = name;
        jpInformation = new JPInformation(name);
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
        this.add(jpRoom);
        this.add(jpSideBar);
        this.add(jpInformation);
        this.add(jpUpdateAccount);
        this.add(jpUpdateRoom);
        this.setVisible(true);
    }
    public void setupComponent () {
        jpRoom.setBounds(0, 0, 580, FRAME_HIGH*95/100);
        jpUpdateAccount.setBounds(579, 0, FRAME_WIDTH/4, FRAME_HIGH*43/100);
        jpUpdateRoom.setBounds(579, FRAME_HIGH*43/100, FRAME_WIDTH/4, FRAME_HIGH*50/100);
        jpInformation.setBounds(880, 0, 295, 558);
        jpInformation.getJbQuit().addActionListener(hotelManagerListener);
    }

    public RoomManagement getJpRoom() {
        return jpRoom;
    }
    public void refreshRoom() {
        jpRoom.setVisible(false);
        jpRoom = new RoomManagement();
        jpRoom.setBounds(0, 0, 580, FRAME_HIGH*95/100);
        this.add(jpRoom);
    }
    public void quitApp() {
        jpInformation.getChatAdmin().closePort();
        this.dispose();
    }
    public static void main(String[] args) {
        new HotelManagement("Admin");
    }
}
