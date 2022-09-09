package view.user;

import controller.user.UserViewListener;

import javax.swing.*;
import java.awt.*;

public class UserViewFrame extends JFrame {
    static final int FRAME_WIDTH = 800, FRAME_HIGH = 600;
    private ServicePanel servicePanel;
    private ChatboxPanel chatboxPanel;
    private UserViewListener userViewListener = new UserViewListener(this);

    public UserViewFrame(String name) {
        this.setupJFrame();
        servicePanel = new ServicePanel(name);
        chatboxPanel = new ChatboxPanel(name);
        this.addComponent();
        this.setVisible(true);
    }

    private void setupJFrame() {
        this.setTitle("SG Hotel");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent() {
        this.add(servicePanel);
        this.add(chatboxPanel);
        this.chatboxPanel.getQuitButton().addActionListener(userViewListener);
    }

    public void quitApp() {
        chatboxPanel.getChatUser().setRun(false);
        chatboxPanel.getChatUser().closePort();
        this.dispose();
    }
}
