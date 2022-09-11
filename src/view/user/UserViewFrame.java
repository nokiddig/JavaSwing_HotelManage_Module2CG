package view.user;

import controller.user.UserViewListener;

import javax.swing.*;
import java.awt.*;

public class UserViewFrame extends JFrame {
    static final int FRAME_WIDTH = 800, FRAME_HIGH = 600;
    private ServicePanel servicePanel;
    private ChatboxPanel chatboxPanel;
    private UserViewListener userViewListener;

    public UserViewFrame(String name) {
        this.setupJFrame();
        servicePanel = new ServicePanel(name);
        chatboxPanel = new ChatboxPanel(name);
        userViewListener = new UserViewListener(this);
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
        this.setupIcon();
    }

    private void addComponent() {
        this.add(servicePanel);
        this.add(chatboxPanel);
        this.chatboxPanel.getQuitButton().addActionListener(userViewListener);
    }

    private void setupIcon() {
        Image iconImage = Toolkit.getDefaultToolkit().createImage("image\\sImage.jpg");
        this.setIconImage(iconImage);
    }

    public ChatboxPanel getChatboxPanel() {
        return chatboxPanel;
    }
}
