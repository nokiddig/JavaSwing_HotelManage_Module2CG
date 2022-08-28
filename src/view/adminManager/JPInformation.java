package view.adminManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPInformation extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private JLabel jlNoti = new JLabel("Notification: ");
    private JLabel jlInfo = new JLabel("Information: ");
    private JTextArea jtaNoti = new JTextArea(10, 10);
    private JTextArea jtaInfo = new JTextArea(10, 10);

    public JPInformation () {
        this.setupBorder("Hello");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
        this.add(jlNoti);
        this.add(jtaNoti);
        this.add(jtaInfo);
        this.add(jlInfo);
    }

    private void setupComponent() {
        this.setupJLNoti();
    }

    private void setupJLNoti() {
        jlNoti = new JLabel("Notification: ");
        jlNoti.setFont(new Font("times new roman", Font.ITALIC, 16));
        jlNoti.setForeground(Color.BLACK);
        jlNoti.setSize(150, 30);
        jlNoti.setLocation(20, 20);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
