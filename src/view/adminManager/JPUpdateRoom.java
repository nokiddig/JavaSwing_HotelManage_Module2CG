package view.adminManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPUpdateRoom extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("arial", Font.PLAIN, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);
    private static JTextField jtfID = new JTextField(), jtfLarge = new JTextField();
    private static JTextField jtfBed = new JTextField(), jtfPrice = new JTextField();
    private static JLabel jlID = new JLabel("ID: "), jlLarge = new JLabel("Large: ");
    private static JLabel jlPrice = new JLabel("Price: "), jlBed = new JLabel("Num of bed: ");
    private static JButton jbEdit = new JButton("Edit");
    private static JButton jbAdd = new JButton("Add");
    private static JButton jbDelete = new JButton("Delete");

    public JPUpdateRoom() {
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
        jlID.setSize(150, 30);
        jlID.setLocation(15, 40);

        jtfID.setSize(150, 30);
        jtfID.setLocation(110, 40);
    }
    private void setupLarge() {
        jlLarge.setFont(jlFont);
        jlLarge.setForeground(Color.black);
        jlLarge.setSize(150, 30);
        jlLarge.setLocation(15, 85);

        jtfLarge.setSize(150, 30);
        jtfLarge.setLocation(110, 85);
    }

    private void setupBed() {
        jlBed.setFont(jlFont);
        jlBed.setForeground(Color.black);
        jlBed.setSize(150, 30);
        jlBed.setLocation(15, 130);

        jtfBed.setSize(150, 30);
        jtfBed.setLocation(110, 130);
    }

    private void setupPrice() {
        jlPrice.setFont(jlFont);
        jlPrice.setForeground(Color.black);
        jlPrice.setSize(150, 30);
        jlPrice.setLocation(15, 175);

        jtfPrice.setSize(150, 30);
        jtfPrice.setLocation(110, 175);
    }
    private void setupJBAdd() {
        jbAdd.setBackground(Color.yellow);
        jbAdd.setFont(jbFont);
        jbAdd.setSize(80, 30);
        jbAdd.setLocation(15, 230);
    }

    private void setupJBEdit() {
        jbEdit.setBackground(Color.yellow);
        jbEdit.setFont(jbFont);
        jbEdit.setSize(80, 30);
        jbEdit.setLocation(107, 230);
    }

    private void setupJBDelete() {
        jbDelete.setBackground(Color.yellow);
        jbDelete.setFont(jbFont);
        jbDelete.setSize(80, 30);
        jbDelete.setLocation(200, 230);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
