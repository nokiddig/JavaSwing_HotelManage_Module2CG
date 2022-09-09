package view.user;

import controller.user.UserViewListener;
import view.login.Login;

import javax.swing.*;
import java.awt.*;

public class JFAllUserView extends JFrame {
    static final int FRAME_WIDTH = 800, FRAME_HIGH = 600;
    private JPService jpService;
    private JPChatbox jpChatbox;
    private UserViewListener userViewListener = new UserViewListener(this);

    public JFAllUserView(String name) {
        this.setupJFrame();
        jpService = new JPService(name);
        jpChatbox = new JPChatbox(name);
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
        this.add(jpService);
        this.add(jpChatbox);
        this.jpChatbox.getJbQuit().addActionListener(userViewListener);
    }

    public void quitApp() {
        jpChatbox.getChatUser().setRun(false);
        jpChatbox.getChatUser().closePort();
        this.dispose();
    }
}
