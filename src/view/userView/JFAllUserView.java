package view.userView;

import controller.userListener.UserViewListener;

import javax.swing.*;
import java.awt.*;

public class JFAllUserView extends JFrame {
    static final int FRAME_WIDTH = 800, FRAME_HIGH = 600;
    private final JPService jpService;
    private final JPChatbox jpChatbox;
    private final UserViewListener userViewListener = new UserViewListener(this);

    public JFAllUserView(String name) {
        this.setupJFrame();
        jpService = new JPService(name);
        jpChatbox = new JPChatbox(name);
        this.addComponent();
        this.setVisible(true);
    }

    private void setupJFrame() {
        this.setLayout(new GridLayout(1, 3));
        this.setTitle("SG Hotel");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2));
    }

    private void addComponent() {
        this.add(jpService);
        this.add(jpChatbox);
        this.jpChatbox.getJbQuit().addActionListener(userViewListener);
    }

    public void quitApp() {
        this.dispose();
    }
}
