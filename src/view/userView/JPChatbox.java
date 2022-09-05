package view.userView;

import controller.userListener.ChatBoxUserListener;
import model.chat.ChatUser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPChatbox extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("times new roman", Font.ITALIC, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);

    private JLabel jlNoti = new JLabel("Notification: ");
    private final JLabel jlRep = new JLabel("Reply: ");

    private final JTextArea jtaNoti = new JTextArea(10, 10);
    private final JTextArea jtaRep = new JTextArea(10, 10);

    private final JButton jbSend = new JButton("Send");
    private final JButton jbClear = new JButton("Clear all");
    private final JButton jbRefresh = new JButton("Refresh");
    private final ChatUser chatUser = new ChatUser();
    private final ChatBoxUserListener chatBoxUserListener = new ChatBoxUserListener(this);
    private String nameUser;
    public JPChatbox(String name) {
        this.setupBorder("Chat with admin");
        this.nameUser = name;
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
        chatUser.setJpChatbox(this);
        chatUser.start();
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
        jbSend.addActionListener(chatBoxUserListener);
    }
    private void setupJBClear() {
        jbClear.setBackground(Color.yellow);
        jbClear.setFont(jbFont);
        jbClear.setBounds(135,400,95,30);
        jbClear.addActionListener(chatBoxUserListener);
    }
    private void setupJBRefresh() {
        jbRefresh.setBackground(Color.yellow);
        jbRefresh.setFont(jbFont);
        jbRefresh.setBounds(265,400,90,30);
        jbRefresh.addActionListener(chatBoxUserListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }

    public JTextArea getJtaRep() {
        return jtaRep;
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public String getNameUser() {
        return nameUser;
    }
    public void addMessage(String mes) {
        String allMess = jtaNoti.getText();
        jtaNoti.setText(allMess+ mes + "\n");
    }
}
