package view.adminManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPInformation extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("times new roman", Font.ITALIC, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);

    private JLabel jlNoti = new JLabel("Notification: ");
    private JLabel jlRep = new JLabel("Reply: ");

    private JTextArea jtaNoti = new JTextArea(10, 10);
    private JTextArea jtaRep = new JTextArea(10, 10);

    private JButton jbSend = new JButton("Send"), jbQuit = new JButton("Quit"), jbClear = new JButton("Clear all"), jbRefresh = new JButton("Refresh");
    private JButton jbCheckRoom = new JButton("Check"), jbOrder = new JButton("Order"), jbTurnover = new JButton("Turnover");

    private JLabel jlID = new JLabel("Room ID: ");
    private JTextField jtfID = new JTextField("ID");
    private JComboBox<String> jcbbService = new JComboBox<String>();
    public JPInformation (String name) {
        this.setupBorder("Hello " + name);
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }
    private void setupComponent() {
        this.setupJLNoti();
        this.setupJTANoti();
        this.setupJLRep();
        this.setupJTARep();
        this.setupJBQuit();
        this.setupJBClear();
        this.setupJBSend();
        this.setupJBRefresh();
        this.setupService();
        this.setupJBCheckRoom();
        this.setupJBOrder();
        this.setupJBTurnover();
    }




    private void addComponent() {
        this.add(jlNoti);
        this.add(jtaNoti);
        this.add(jtaRep);
        this.add(jlRep);
        this.add(jbClear);
        this.add(jbQuit);
        this.add(jbRefresh);
        this.add(jbSend);
        this.add(jlID);
        this.add(jtfID);
        this.add(jcbbService);
        this.add(jbCheckRoom);
        this.add(jbOrder);
        this.add(jbTurnover);
    }

    private void setupJLNoti() {
        jlNoti = new JLabel("Notification: ");
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
        jlRep.setBounds(20, 200, 150, 30);
    }
    private void setupJTARep() {
        jtaRep.setBounds(10, 230, 275,100);
        jtaRep.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void setupJBSend() {
        jbSend.setBackground(Color.blue);
        jbSend.setFont(jbFont);
        jbSend.setBounds(15, 340, 70, 30);
    }
    private void setupJBClear() {
        jbClear.setBackground(Color.yellow);
        jbClear.setFont(jbFont);
        jbClear.setBounds(90, 340,95,30);
    }
    private void setupJBRefresh() {
        jbRefresh.setBackground(Color.yellow);
        jbRefresh.setFont(jbFont);
        jbRefresh.setBounds(190, 340, 90, 30);
    }
    private void setupService() {
        jlID.setFont(jlFont);
        jlID.setForeground(Color.BLACK);
        jlID.setBounds(20, 390,150,30);

        jtfID.setBounds(90, 390, 70,30);

        String nameService[] = {"Service 1", "Service 2", "Service3"};
        jcbbService = new JComboBox<>(nameService);
        jcbbService.setBounds(170, 390, 100, 30);
    }


    private void setupJBOrder() {
        jbOrder.setBackground(Color.yellow);
        jbOrder.setFont(jbFont);
        jbOrder.setBounds(60, 430, 80,30);
    }

    private void setupJBCheckRoom() {
        jbCheckRoom.setBackground(Color.yellow);
        jbCheckRoom.setFont(jbFont);
        jbCheckRoom.setBounds(160, 430, 80, 30);

    }
    private void setupJBTurnover() {
        jbTurnover.setBackground(Color.yellow);
        jbTurnover.setFont(jbFont);
        jbTurnover.setBounds(20, 510, 100,30);
    }
    private void setupJBQuit() {
        jbQuit.setBackground(Color.yellow);
        jbQuit.setFont(jbFont);
        jbQuit.setBounds(200, 510, 80,30);
    }
    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
