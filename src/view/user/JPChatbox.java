package view.user;

import controller.user.ChatBoxUserListener;
import model.chat.ChatUser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPChatbox extends JPanel {
    private final Font FONT_BORDER = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font FONT_LABEL = new Font("times new roman", Font.ITALIC, 16);
    private final Font FONT_BUTTON = new Font("Arial", Font.BOLD, 14);

    private JLabel jlNotification = new JLabel("Notification: ");
    private JLabel jlRep = new JLabel("Reply: ");

    private JTextArea jtaNotification = new JTextArea(10, 10);
    private JTextArea jtaRep = new JTextArea(10, 10);

    private JButton jbSend = new JButton("Send");
    private JButton jbClear = new JButton("Clear all");
    private JButton jbRefresh = new JButton("Refresh");
    private JButton jbQuit = new JButton("Quit");
    private ChatUser chatUser = new ChatUser();
    private ChatBoxUserListener chatBoxUserListener = new ChatBoxUserListener(this);
    private String nameUser;
    private String allMessage = "";

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
        this.setupJBQuit();
    }

    private void addComponent() {
        this.add(jlNotification);
        this.add(jtaNotification);
        this.add(jlRep);
        this.add(jtaRep);
        this.add(jbSend);
        this.add(jbClear);
        this.add(jbRefresh);
        this.add(jbQuit);
    }

    private void setupShowMess() {
        jlNotification = new JLabel("Message: ");
        jlNotification.setFont(FONT_LABEL);
        jlNotification.setForeground(Color.BLACK);
        jlNotification.setBounds(20,20,150,30);

        jtaNotification.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jtaNotification.setLineWrap(true);
        jtaNotification.setBounds(10,50,370,200);
        chatUser.setJpChatbox(this);
        chatUser.start();
    }

    private void setupRep() {
        jlRep.setFont(FONT_LABEL);
        jlRep.setForeground(Color.black);
        jlRep.setBounds(20, 250, 150, 30);

        jtaRep.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jtaRep.setBounds(10,280,370,100);
    }

    private void setupJBSend() {
        jbSend.setBackground(Color.blue);
        jbSend.setFont(FONT_BUTTON);
        jbSend.setBounds(30,400,70,30);
        jbSend.addActionListener(chatBoxUserListener);
    }

    private void setupJBClear() {
        jbClear.setBackground(Color.yellow);
        jbClear.setFont(FONT_BUTTON);
        jbClear.setBounds(135,400,95,30);
        jbClear.addActionListener(chatBoxUserListener);
    }

    private void setupJBRefresh() {
        jbRefresh.setBackground(Color.yellow);
        jbRefresh.setFont(FONT_BUTTON);
        jbRefresh.setBounds(265,400,90,30);
        jbRefresh.addActionListener(chatBoxUserListener);
    }

    private void setupJBQuit() {
        jbQuit.setBackground(Color.yellow);
        jbQuit.setFont(FONT_BUTTON);
        jbQuit.setBounds(265,480,90,30);
        jbQuit.addActionListener(chatBoxUserListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FONT_BORDER));
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

    public JButton getJbQuit() {
        return jbQuit;
    }

    public JTextArea getJTANotification() {
        return jtaNotification;
    }

    public void addMessage(String mes) {
        allMessage += mes + "\n";
        jtaNotification.setText(allMessage);
    }

    public void refreshJTANotification() {
        this.jtaNotification.setText(allMessage);
    }
}
