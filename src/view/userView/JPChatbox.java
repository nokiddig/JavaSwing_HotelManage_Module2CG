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
        this.setupRep();
        this.addComponent();
        this.setupButton();
    }

    private void setupButton() {
        this.setupJBSend();
        this.setupJBClear();
        this.setupJBRefresh();
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
        jlNoti.setBounds(20,20,150,30);


        jtaNoti.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jtaNoti.setLineWrap(true);
        jtaNoti.setBounds(10,50,370,200);
    }
    private void setupRep() {
        jlRep.setFont(jlFont);
        jlRep.setForeground(Color.black);
        jlRep.setBounds(20, 250, 150, 30);

        jtaRep.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jtaRep.setBounds(10,280,370,100);
    }

    private void setupJBSend() {
        jbSend.setBackground(Color.blue);
        jbSend.setFont(jbFont);
        jbSend.setBounds(30,400,70,30);
    }
    private void setupJBClear() {
        jbClear.setBackground(Color.yellow);
        jbClear.setFont(jbFont);
        jbClear.setBounds(135,400,95,30);
    }
    private void setupJBRefresh() {
        jbRefresh.setBackground(Color.yellow);
        jbRefresh.setFont(jbFont);
        jbRefresh.setBounds(265,400,90,30);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
