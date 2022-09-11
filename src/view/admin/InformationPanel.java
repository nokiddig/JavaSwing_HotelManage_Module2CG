package view.admin;

import controller.admin.InformationListener;
import model.chat.ChatAdmin;
import model.entity.FontStyle;
import model.input.ReadService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class InformationPanel extends JPanel {
    private JLabel notificationLabel = new JLabel("Notification: ");
    private JLabel repLabel = new JLabel("Reply: ");

    private JTextArea notificationTextArea = new JTextArea(10, 10);
    private JTextArea repTextArea = new JTextArea(10, 10);

    private JButton sendButton = new JButton("Send");
    private JButton quitButton = new JButton("Quit");
    private JButton clearButton = new JButton("Clear all");
    private JButton refreshButton = new JButton("Refresh");
    private JButton checkRoomButton = new JButton("Check");
    private JButton orderButton = new JButton("Order");
    private JButton turnoverButton = new JButton("Turnover");

    private JLabel iDLabel = new JLabel("Room ID: ");
    private JTextField iDTextField = new JTextField("ID");
    private JComboBox<String> serviceComboBox = new JComboBox<>();
    private InformationListener informationListener = new InformationListener(this);
    private ChatAdmin chatAdmin = new ChatAdmin();
    private String allMessage = "";
    private ReadService readService = new ReadService();

    public InformationPanel(String name) {
        this.setupBorder("Hello " + name);
        this.setLayout(null);
        readService.readAllService();
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
        notificationLabel.setFont(FontStyle.FONT_LABEL.getFont());
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
        repLabel.setFont(FontStyle.FONT_LABEL.getFont());
        repLabel.setForeground(Color.black);
        repLabel.setBounds(20, 200, 150, 30);
    }

    private void setupRepTextArea() {
        repTextArea.setBounds(10, 230, 275,100);
        repTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setupSendButton() {
        sendButton.setBackground(Color.blue);
        sendButton.setFont(FontStyle.FONT_BUTTON.getFont());
        sendButton.setBounds(15, 340, 70, 30);
        sendButton.addActionListener(informationListener);
    }

    private void setupClearButton() {
        clearButton.setBackground(Color.yellow);
        clearButton.setFont(FontStyle.FONT_BUTTON.getFont());
        clearButton.setBounds(90, 340,95,30);
        clearButton.addActionListener(informationListener);
    }

    private void setupRefreshButton() {
        refreshButton.setBackground(Color.yellow);
        refreshButton.setFont(FontStyle.FONT_BUTTON.getFont());
        refreshButton.setBounds(190, 340, 90, 30);
        refreshButton.addActionListener(informationListener);
    }

    private void setupService() {
        iDLabel.setFont(FontStyle.FONT_LABEL.getFont());
        iDLabel.setForeground(Color.BLACK);
        iDLabel.setBounds(20, 390,150,30);
        iDTextField.setBounds(90, 390, 70,30);

        serviceComboBox = new JComboBox<>(readService.getListServiceName());
        serviceComboBox.setBounds(170, 390, 100, 30);
    }

    private void setupOrderButton() {
        orderButton.setBackground(Color.yellow);
        orderButton.setFont(FontStyle.FONT_BUTTON.getFont());
        orderButton.setBounds(60, 430, 80,30);
        orderButton.addActionListener(informationListener);
    }

    private void setupCheckRoomButton() {
        checkRoomButton.setBackground(Color.yellow);
        checkRoomButton.setFont(FontStyle.FONT_BUTTON.getFont());
        checkRoomButton.setBounds(160, 430, 80, 30);
        checkRoomButton.addActionListener(informationListener);
    }

    private void setupTurnoverButton() {
        turnoverButton.setBackground(Color.yellow);
        turnoverButton.setFont(FontStyle.FONT_BUTTON.getFont());
        turnoverButton.setBounds(20, 510, 100,30);
        turnoverButton.addActionListener(informationListener);
    }

    private void setupQuitButton() {
        quitButton.setBackground(Color.yellow);
        quitButton.setFont(FontStyle.FONT_BUTTON.getFont());
        quitButton.setBounds(200, 510, 80,30);
        quitButton.addActionListener(informationListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, FontStyle.FONT_BORDER.getFont()));
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

    public JTextField getIDTextField() {
        return iDTextField;
    }

    public void addMessage(String mes) {
        allMessage += mes + "\n";
        notificationTextArea.setText(allMessage);
    }

    public JComboBox<String> getServiceComboBox() {
        return serviceComboBox;
    }

    public void refreshNotificationTextArea() {
        this.notificationTextArea.setText(allMessage);
    }
}
