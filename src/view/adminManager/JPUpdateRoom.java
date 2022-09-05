package view.adminManager;

import controller.adminListener.UpdateRoomListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPUpdateRoom extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("arial", Font.PLAIN, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);
    private JTextField jtfID = new JTextField(), jtfLarge = new JTextField();
    private JTextField jtfBed = new JTextField(), jtfPrice = new JTextField();
    private JLabel jlID = new JLabel("ID: "), jlLarge = new JLabel("Large: ");
    private JLabel jlPrice = new JLabel("Price: "), jlBed = new JLabel("Num of bed: ");
    private JButton jbEdit = new JButton("Edit");
    private JButton jbAdd = new JButton("Add");
    private JButton jbDelete = new JButton("Delete");
    private UpdateRoomListener updateRoomListener = new UpdateRoomListener(this);
    private JFHotelManagement HM;

    public JPUpdateRoom(JFHotelManagement HM) {
        this.HM = HM;
        this.setupBorder("Room");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
        this.add(jlID);
        this.add(jtfID);
        this.add(jlLarge);
        this.add(jtfLarge);
        this.add(jlBed);
        this.add(jtfBed);
        this.add(jlPrice);
        this.add(jtfPrice);
        this.add(jbAdd);
        this.add(jbEdit);
        this.add(jbDelete);
    }

    private void setupComponent() {
        this.setupID();
        this.setupLarge();
        this.setupBed();
        this.setupPrice();
        this.setupJBAdd();
        this.setupJBEdit();
        this.setupJBDelete();
    }

    private void setupID() {
        jlID.setFont(jlFont);
        jlID.setForeground(Color.black);
        jlID.setBounds(15, 40,150,30);

        jtfID.setBounds(110, 40,150,30);
    }
    private void setupLarge() {
        jlLarge.setFont(jlFont);
        jlLarge.setForeground(Color.black);
        jlLarge.setBounds(15, 85, 150,30);

        jtfLarge.setBounds(110, 85,150,30);
    }

    private void setupBed() {
        jlBed.setFont(jlFont);
        jlBed.setForeground(Color.black);
        jlBed.setBounds(15, 130,150,30);

        jtfBed.setBounds(110, 130, 150,30);
    }

    private void setupPrice() {
        jlPrice.setFont(jlFont);
        jlPrice.setForeground(Color.black);
        jlPrice.setBounds(15, 175, 150,30);

        jtfPrice.setBounds(110, 175,150,30);
    }
    private void setupJBAdd() {
        jbAdd.setBackground(Color.yellow);
        jbAdd.setFont(jbFont);
        jbAdd.setBounds(15, 240, 80,30);
        jbAdd.addActionListener(updateRoomListener);
    }

    private void setupJBEdit() {
        jbEdit.setBackground(Color.yellow);
        jbEdit.setFont(jbFont);
        jbEdit.setBounds(107, 240,80,30);
        jbEdit.addActionListener(updateRoomListener);
    }

    private void setupJBDelete() {
        jbDelete.setBackground(Color.yellow);
        jbDelete.setFont(jbFont);
        jbDelete.setBounds(200, 240,80,30);
        jbDelete.addActionListener(updateRoomListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }

    public JTextField getJtfID() {
        return jtfID;
    }

    public JTextField getJtfLarge() {
        return jtfLarge;
    }

    public JTextField getJtfBed() {
        return jtfBed;
    }

    public JTextField getJtfPrice() {
        return jtfPrice;
    }

    public JFHotelManagement getHM() {
        return HM;
    }
}
