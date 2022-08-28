package view.adminManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPInformation extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("times new roman", Font.ITALIC, 16);
    private JLabel jlNoti = new JLabel("Notification: ");
    private JLabel jlRep = new JLabel("Reply: ");
    private JTextArea jtaNoti = new JTextArea(10, 10);
    private JTextArea jtaRep = new JTextArea(10, 10);
    private JButton jbSend, jbQuit, jb;

    public JPInformation () {
        this.setupBorder("Hello");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
        this.add(jlNoti);
        this.add(jtaNoti);
        this.add(jtaRep);
        this.add(jlRep);
    }

    private void setupComponent() {
        this.setupJLNoti();
        this.setupJTANoti();
        this.setupJLRep();
        this.setupJTARep();
    }

    private void setupJLNoti() {
        jlNoti = new JLabel("Notification: ");
        jlNoti.setFont(jlFont);
        jlNoti.setForeground(Color.BLACK);
        jlNoti.setSize(150, 30);
        jlNoti.setLocation(20, 20);
    }
    private void setupJTANoti() {
        jtaNoti.setSize(275, 250);
        jtaNoti.setLocation(10, 50);
        jtaNoti.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setupJLRep() {
        jlRep.setFont(jlFont);
        jlRep.setForeground(Color.black);
        jlRep.setSize(150, 30);
        jlRep.setLocation(20, 300);
    }
    private void setupJTARep() {
        jtaRep.setSize(275, 100);
        jtaRep.setLocation(10, 330);
        jtaRep.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
