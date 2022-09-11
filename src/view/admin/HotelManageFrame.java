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
    private JPanel sideBarPanel;
    private RoomManagePanel roomGridPanel;
    private InformationPanel informationPanel;
    private UpdateRoomPanel updateRoomPanel;
    private UpdateAccountPanel updateAccountPanel;
    private final String NAME;
    private HotelManagerListener hotelManagerListener;

    public HotelManageFrame(String name) {
        this.NAME = name;
        this.initializeComponent();
        this.setupJFrame();
        this.setupComponent();
        this.addComponent();
        this.setVisible(true);
    }

    private void initializeComponent() {
        this.informationPanel = new InformationPanel(NAME);
        sideBarPanel = new JPanel(new GridLayout(1, 2));
        roomGridPanel = new RoomManagePanel();
        updateRoomPanel = new UpdateRoomPanel(this);
        updateAccountPanel = new UpdateAccountPanel();
        hotelManagerListener = new HotelManagerListener(this);
    }

    public void setupJFrame() {
        this.setTitle("Hotel Management.");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setupIcon();
    }

    private void setupIcon() {
        Image iconImage = Toolkit.getDefaultToolkit().createImage("image\\sImage.jpg");
        this.setIconImage(iconImage);
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
