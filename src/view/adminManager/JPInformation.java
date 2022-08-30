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
    public JPInformation () {
        this.setupBorder("Hello");
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
    private void setupService() {
        jlID.setFont(jlFont);
        jlID.setForeground(Color.BLACK);
        jlID.setSize(150, 30);
        jlID.setLocation(20, 390);

        jtfID.setSize(70, 30);
        jtfID.setLocation(90, 390);

        String nameService[] = {"Service 1", "Service 2", "Service3"};
        jcbbService = new JComboBox<>(nameService);
        jcbbService.setBounds(100, 50, 150, 20);
        jcbbService.setSize(100, 30);
        jcbbService.setLocation(170,390);
    }


    private void setupJBOrder() {
        jbOrder.setBackground(Color.yellow);
        jbOrder.setFont(jbFont);
        jbOrder.setSize(80, 30);
        jbOrder.setLocation(60, 430);
    }

    private void setupJBCheckRoom() {
        jbCheckRoom.setBackground(Color.yellow);
        jbCheckRoom.setFont(jbFont);
        jbCheckRoom.setSize(80, 30);
        jbCheckRoom.setLocation(160, 430);

    }
    private void setupJBTurnover() {
        jbTurnover.setBackground(Color.yellow);
        jbTurnover.setFont(jbFont);
        jbTurnover.setSize(100, 30);
        jbTurnover.setLocation(20, 510);
    }
    private void setupJBQuit() {
        jbQuit.setBackground(Color.yellow);
        jbQuit.setFont(jbFont);
        jbQuit.setSize(80, 30);
        jbQuit.setLocation(200, 510);
    }
    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
