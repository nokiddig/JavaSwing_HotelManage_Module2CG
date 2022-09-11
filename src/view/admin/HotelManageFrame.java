package view.admin;

import controller.admin.HotelManagerListener;
import model.input.ReadWriteAccount;
import model.input.ReadWriteRoom;
import model.input.ReadWriteTurnover;
import view.login.Login;

import javax.swing.*;
import java.awt.*;

public class HotelManageFrame extends JFrame {
    static final int FRAME_WIDTH = 1200, FRAME_HIGH = 600;
    private final JPanel sideBarPanel = new JPanel(new GridLayout(1, 2));
    private RoomManagePanel roomGridPanel = new RoomManagePanel();
    private final InformationPanel informationPanel;
    private final UpdateRoomPanel updateRoomPanel = new UpdateRoomPanel(this);
    private final UpdateAccountPanel updateAccountPanel = new UpdateAccountPanel();
    private final String name;
    private final HotelManagerListener hotelManagerListener = new HotelManagerListener(this);
    public HotelManageFrame(String name) {
        this.name = name;
        this.informationPanel = new InformationPanel(name);
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
        this.add(roomGridPanel);
        this.add(sideBarPanel);
        this.add(informationPanel);
        this.add(updateAccountPanel);
        this.add(updateRoomPanel);
    }

    public void setupComponent () {
        roomGridPanel.setBounds(0, 0, 580, FRAME_HIGH*95/100);
        updateAccountPanel.setBounds(579, 0, FRAME_WIDTH/4, FRAME_HIGH*43/100);
        updateRoomPanel.setBounds(579, FRAME_HIGH*43/100, FRAME_WIDTH/4, FRAME_HIGH*50/100);
        informationPanel.setBounds(880, 0, 295, 558);
        informationPanel.getQuitButton().addActionListener(hotelManagerListener);
    }

    public void refreshRoom() {
        roomGridPanel.setVisible(false);
        roomGridPanel = new RoomManagePanel();
        roomGridPanel.setBounds(0, 0, 580, FRAME_HIGH*95/100);
        this.add(roomGridPanel);
    }

    public void quitApp() {
        ReadWriteAccount.getInstance().writeListUser();
        ReadWriteRoom.getInstance().writeListRooms();
        ReadWriteTurnover.getInstance().writeTurnover();
        informationPanel.getChatAdmin().setRun(false);
        informationPanel.getChatAdmin().closePort();
        new Login();
        this.dispose();
    }
}
