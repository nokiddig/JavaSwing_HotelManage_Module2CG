package view.admin;

import controller.admin.InformationListener;
import model.chat.ChatAdmin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InformationPanel extends JPanel {
    private final Font FONT_BORDER = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font FONT_LABEL = new Font("times new roman", Font.ITALIC, 16);
    private final Font FONT_BUTTON = new Font("Arial", Font.BOLD, 14);

    private JLabel notificationLabel = new JLabel("Notification: ");
    private final JLabel repLabel = new JLabel("Reply: ");

    private final JTextArea notificationTextArea = new JTextArea(10, 10);
    private final JTextArea repTextArea = new JTextArea(10, 10);

    private final JButton sendButton = new JButton("Send");
    private final JButton quitButton = new JButton("Quit");
    private final JButton clearButton = new JButton("Clear all");
    private final JButton refreshButton = new JButton("Refresh");
    private final JButton checkRoomButton = new JButton("Check");
    private final JButton orderButton = new JButton("Order");
    private final JButton turnoverButton = new JButton("Turnover");

    private final JLabel iDLabel = new JLabel("Room ID: ");
    private final JTextField iDTextField = new JTextField("ID");
    private JComboBox<String> serviceComboBox = new JComboBox<>();
    private final InformationListener informationListener = new InformationListener(this);
    private final ChatAdmin chatAdmin = new ChatAdmin();
    private String allMessage = "";

    public InformationPanel(String name) {
        this.setupBorder("Hello " + name);
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void setupComponent() {
        this.setupNotificationLabel();
        this.setupNotification();
        this.setupRepLabel();
        this.setupRepTextArea();
        this.setupQuitButton();
        this.setupClearButton();
        this.setupSendButton();
        this.setupRefreshButton();
        this.setupService();
        this.setupCheckRoomButton();
        this.setupOrderButton();
        this.setupTurnoverButton();
    }

    private void addComponent() {
        this.add(notificationLabel);
        this.add(notificationTextArea);
        
        this.add(repTextArea);
        this.add(repLabel);
        
        this.add(clearButton);
        this.add(quitButton);
        this.add(refreshButton);
        this.add(sendButton);
        
        this.add(iDLabel);
        this.add(iDTextField);
        
        this.add(serviceComboBox);
        this.add(checkRoomButton);
        this.add(orderButton);
        this.add(turnoverButton);
    }

    private void setupNotificationLabel() {
        notificationLabel = new JLabel("Notification: ");
        notificationLabel.setFont(FONT_LABEL);
        notificationLabel.setForeground(Color.BLACK);
        notificationLabel.setSize(150, 30);
        notificationLabel.setLocation(20, 20);
    }

    private void setupNotification() {
        notificationTextArea.setSize(275, 150);
        notificationTextArea.setLocation(10, 50);
        notificationTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        notificationTextArea.setLineWrap(true);
        chatAdmin.setJpInformation(this);
        chatAdmin.start();
    }

    private void setupRepLabel() {
        repLabel.setFont(FONT_LABEL);
        repLabel.setForeground(Color.black);
        repLabel.setBounds(20, 200, 150, 30);
    }

    private void setupRepTextArea() {
        repTextArea.setBounds(10, 230, 275,100);
        repTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setupSendButton() {
        sendButton.setBackground(Color.blue);
        sendButton.setFont(FONT_BUTTON);
        sendButton.setBounds(15, 340, 70, 30);
        sendButton.addActionListener(informationListener);
    }

    private void setupClearButton() {
        clearButton.setBackground(Color.yellow);
        clearButton.setFont(FONT_BUTTON);
        clearButton.setBounds(90, 340,95,30);
        clearButton.addActionListener(informationListener);
    }

    private void setupRefreshButton() {
        refreshButton.setBackground(Color.yellow);
        refreshButton.setFont(FONT_BUTTON);
        refreshButton.setBounds(190, 340, 90, 30);
        refreshButton.addActionListener(informationListener);
    }

    private void setupService() {
        iDLabel.setFont(FONT_LABEL);
        iDLabel.setForeground(Color.BLACK);
        iDLabel.setBounds(20, 390,150,30);
        iDTextField.setBounds(90, 390, 70,30);

        String nameService[] = {"Service 1", "Service 2", "Service 3"};
        serviceComboBox = new JComboBox<>(nameService);
        serviceComboBox.setBounds(170, 390, 100, 30);
    }

    private void setupOrderButton() {
        orderButton.setBackground(Color.yellow);
        orderButton.setFont(FONT_BUTTON);
        orderButton.setBounds(60, 430, 80,30);
        orderButton.addActionListener(informationListener);
    }

    private void setupCheckRoomButton() {
        checkRoomButton.setBackground(Color.yellow);
        checkRoomButton.setFont(FONT_BUTTON);
        checkRoomButton.setBounds(160, 430, 80, 30);
        checkRoomButton.addActionListener(informationListener);
    }

    private void setupTurnoverButton() {
        turnoverButton.setBackground(Color.yellow);
        turnoverButton.setFont(FONT_BUTTON);
        turnoverButton.setBounds(20, 510, 100,30);
        turnoverButton.addActionListener(informationListener);
    }

    private void setupQuitButton() {
        quitButton.setBackground(Color.yellow);
        quitButton.setFont(FONT_BUTTON);
        quitButton.setBounds(200, 510, 80,30);
        quitButton.addActionListener(informationListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FONT_BORDER));
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public JTextArea getNotificationTextArea() {
        return notificationTextArea;
    }

    public JTextArea getRepTextArea() {
        return repTextArea;
    }

    public ChatAdmin getChatAdmin() {
        return chatAdmin;
    }

    public void addMessage(String mes) {
        allMessage += mes + "\n";
        notificationTextArea.setText(allMessage);
    }

    public void refreshNotificationTextArea() {
        this.notificationTextArea.setText(allMessage);
    }
}
