package view.userView;

import javax.swing.*;
import java.awt.*;

public class AllUserView extends JFrame {
    static final int FRAME_WIDTH = 800, FRAME_HIGH = 600;
    private JPService jpService;
    private JPChatbox jpChatbox;
    public AllUserView(String name) {
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
    }
}
