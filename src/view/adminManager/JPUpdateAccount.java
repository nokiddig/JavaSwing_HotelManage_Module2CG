package view.adminManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPUpdateAccount extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("arial", Font.PLAIN, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);
    private static JTextField jtfName = new JTextField(), jtfPass = new JTextField();
    private static JLabel jlName = new JLabel("Username: "), jlPass = new JLabel("Password: ");
    private static JButton jbEdit = new JButton("Edit");
    private static JButton jbAdd = new JButton("Add");
    private static JButton jbDelete = new JButton("Delete");

    public JPUpdateAccount() {
        this.setupBorder("Account");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
        this.add(jlName);
        this.add(jtfName);
        this.add(jlPass);
        this.add(jtfPass);
        this.add(jbAdd);
        this.add(jbEdit);
        this.add(jbDelete);
    }

    private void setupComponent() {
        this.setupName();
        this.setupPass();
        this.setupJBAdd();
        this.setupJBEdit();
        this.setupJBDelete();
    }

    private void setupName() {
        jlName.setFont(jlFont);
        jlName.setForeground(Color.black);
        jlName.setSize(150, 30);
        jlName.setLocation(15, 60);

        jtfName.setSize(150, 30);
        jtfName.setLocation(100, 60);
    }
    private void setupPass() {
        jlPass.setFont(jlFont);
        jlPass.setForeground(Color.black);
        jlPass.setSize(150, 30);
        jlPass.setLocation(15, 120);

        jtfPass.setSize(150, 30);
        jtfPass.setLocation(100, 120);
    }

    private void setupJBAdd() {
        jbAdd.setBackground(Color.yellow);
        jbAdd.setFont(jbFont);
        jbAdd.setSize(80, 30);
        jbAdd.setLocation(15, 200);
    }

    private void setupJBEdit() {
        jbEdit.setBackground(Color.yellow);
        jbEdit.setFont(jbFont);
        jbEdit.setSize(80, 30);
        jbEdit.setLocation(107, 200);
    }

    private void setupJBDelete() {
        jbDelete.setBackground(Color.yellow);
        jbDelete.setFont(jbFont);
        jbDelete.setSize(80, 30);
        jbDelete.setLocation(200, 200);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
