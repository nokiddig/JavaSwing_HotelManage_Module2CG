package view.user;

import controller.user.ChatBoxUserListener;
import model.chat.ChatUser;
import model.entity.FontStyle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ChatboxPanel extends JPanel {
    private JLabel notificationLabel = new JLabel("Notification: ");
    private JLabel repLabel = new JLabel("Reply: ");

    private JTextArea notificationTextArea = new JTextArea(10, 10);
    private JTextArea repTextArea = new JTextArea(10, 10);

    private JButton sendButton = new JButton("Send");
    private JButton clearButton = new JButton("Clear all");
    private JButton refreshButton = new JButton("Refresh");
    private JButton quitButton = new JButton("Quit");
    private ChatUser chatUser = new ChatUser();
    private ChatBoxUserListener chatBoxUserListener = new ChatBoxUserListener(this);
    private String nameUser;
    private String allMessage = "";

    public ChatboxPanel(String name) {
        this.setupBorder("Chat with admin");
        this.nameUser = name;
        this.setLayout(null);
        this.setupShowMessage();
        this.setupRep();
        this.addComponent();
        this.setupButton();
    }

    private void setupButton() {
        this.setupSendButton();
        this.setupClearButton();
        this.setupRefreshButton();
        this.setupQuitButton();
    }

    private void setupShowMessage() {
        notificationLabel = new JLabel("Message: ");
        notificationLabel.setFont(FontStyle.FONT_LABEL.getFont());
        notificationLabel.setForeground(Color.BLACK);
        notificationLabel.setBounds(20,20,150,30);

        notificationTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        notificationTextArea.setLineWrap(true);
        notificationTextArea.setBounds(10,50,370,200);
        chatUser.setJpChatbox(this);
        chatUser.start();
    }

    private void setupRep() {
        repLabel.setFont(FontStyle.FONT_LABEL.getFont());
        repLabel.setForeground(Color.black);
        repLabel.setBounds(20, 250, 150, 30);

        repTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        repTextArea.setBounds(10,280,370,100);
    }

    private void setupSendButton() {
        sendButton.setBackground(Color.blue);
        sendButton.setFont(FontStyle.FONT_BUTTON.getFont());
        sendButton.setBounds(30,400,70,30);
        sendButton.addActionListener(chatBoxUserListener);
    }

    private void setupClearButton() {
        clearButton.setBackground(Color.yellow);
        clearButton.setFont(FontStyle.FONT_BUTTON.getFont());
        clearButton.setBounds(135,400,95,30);
        clearButton.addActionListener(chatBoxUserListener);
    }

    private void setupRefreshButton() {
        refreshButton.setBackground(Color.yellow);
        refreshButton.setFont(FontStyle.FONT_BUTTON.getFont());
        refreshButton.setBounds(265,400,90,30);
        refreshButton.addActionListener(chatBoxUserListener);
    }

    private void setupQuitButton() {
        quitButton.setBackground(Color.yellow);
        quitButton.setFont(FontStyle.FONT_BUTTON.getFont());
        quitButton.setBounds(265,480,90,30);
        quitButton.addActionListener(chatBoxUserListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FontStyle.FONT_BORDER.getFont()));
    }

    private void addComponent() {
        this.add(notificationLabel);
        this.add(notificationTextArea);
        this.add(repLabel);
        this.add(repTextArea);
        this.add(sendButton);
        this.add(clearButton);
        this.add(refreshButton);
        this.add(quitButton);
    }

    public void addMessage(String mes) {
        allMessage += mes + "\n";
        notificationTextArea.setText(allMessage);
    }

    public void refreshNotificationTextArea() {
        this.notificationTextArea.setText(allMessage);
    }

    public JTextArea getRepTextArea() {
        return repTextArea;
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JTextArea getNotificationTextArea() {
        return notificationTextArea;
    }
}
