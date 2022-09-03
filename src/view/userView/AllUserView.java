package view.userView;

import model.entity.Room;

import javax.swing.*;
import java.awt.*;

public class AllUserView extends JFrame {
    static final int FRAME_WIDTH = 800, FRAME_HIGH = 600;
    private JPService jpService;
    private JPChatbox jpChatbox = new JPChatbox();
    public AllUserView(String name) {
        this.setupJFrame();
        jpService = new JPService(name);
        this.addComponent();
        this.setVisible(true);

    }

    private void setupJFrame() {
        this.setLayout(new GridLayout(1, 3));
        this.setTitle("SG Hotel");
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2));
    }

    private void addComponent() {
        this.add(jpService);
        this.add(jpChatbox);
    }

    public static void main(String[] args) {
        new AllUserView("SyN");
    }
}
