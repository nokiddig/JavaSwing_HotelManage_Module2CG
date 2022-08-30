package view.userView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPChatbox extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("times new roman", Font.ITALIC, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);

    private JLabel jlNoti = new JLabel("Notification: ");
    private JLabel jlRep = new JLabel("Reply: ");

    private JTextArea jtaNoti = new JTextArea(10, 10);
    private JTextArea jtaRep = new JTextArea(10, 10);

    private JButton jbSend = new JButton("Send"), jbClear = new JButton("Clear all"), jbRefresh = new JButton("Refresh");

    public JPChatbox() {
        this.setupBorder("Chat with admin");
        this.setLayout(null);
        this.setupShowMess();
        this.addComponent();
    }

    private void addComponent() {
        this.add(jlNoti);
        this.add(jtaNoti);
        this.add(jlRep);
        this.add(jtaRep);
        this.add(jbSend);
        this.add(jbClear);
        this.add(jbRefresh);
    }

    private void setupShowMess() {
        jlNoti = new JLabel("Message: ");
        jlNoti.setFont(jlFont);
        jlNoti.setForeground(Color.BLACK);
        jlNoti.setSize(150, 30);
        jlNoti.setLocation(20, 20);
    }
    private void setupJTANoti() {
        jtaNoti.setSize(275, 150);
        jtaNoti.setLocation(10, 50);
        jtaNoti.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jtaNoti.setLineWrap(true);
    }

    private void setupJLRep() {
        jlRep.setFont(jlFont);
        jlRep.setForeground(Color.black);
        jlRep.setSize(150, 30);
        jlRep.setLocation(20, 200);
    }
    private void setupJTARep() {
        jtaRep.setSize(275, 100);
        jtaRep.setLocation(10, 230);
        jtaRep.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void setupJBSend() {
        jbSend.setBackground(Color.blue);
        jbSend.setFont(jbFont);
        jbSend.setSize(70, 30);
        jbSend.setLocation(15, 340);
    }
    private void setupJBClear() {
        jbClear.setBackground(Color.yellow);
        jbClear.setFont(jbFont);
        jbClear.setSize(95, 30);
        jbClear.setLocation(90, 340);
    }
    private void setupJBRefresh() {
        jbRefresh.setBackground(Color.yellow);
        jbRefresh.setFont(jbFont);
        jbRefresh.setSize(90, 30);
        jbRefresh.setLocation(190, 340);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
