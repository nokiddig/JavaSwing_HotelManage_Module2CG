package view.admin;

import controller.admin.UpdateAccountListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPUpdateAccount extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("arial", Font.PLAIN, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);
    private final JTextField jtfName = new JTextField();
    private final JTextField jtfPass = new JTextField();
    private final JLabel jlName = new JLabel("Username: ");
    private final JLabel jlPass = new JLabel("Password: ");
    private final JLabel jlStatus = new JLabel();
    private final JButton jbEdit = new JButton("Edit");
    private final JButton jbAdd = new JButton("Add");
    private final JButton jbDelete = new JButton("Delete");
    private final JRadioButton jrbAdmin = new JRadioButton("Admin");
    private final JRadioButton jrbUser = new JRadioButton("User");
    private final UpdateAccountListener updateAccountListener = new UpdateAccountListener(this);

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
        this.add(jlStatus);
        this.add(jbAdd);
        this.add(jbEdit);
        this.add(jbDelete);
        this.add(jrbAdmin);
        this.add(jrbUser);
    }

    private void setupComponent() {
        this.setupName();
        this.setupPass();
        this.setupRadioButton();
        this.setupJLStatus();
        this.setupJBAdd();
        this.setupJBEdit();
        this.setupJBDelete();
    }

    private void setupName() {
        jlName.setFont(jlFont);
        jlName.setForeground(Color.black);
        jlName.setBounds(15, 60,150, 30);

        jtfName.setBounds(100, 60,150, 30);
    }

    private void setupPass() {
        jlPass.setFont(jlFont);
        jlPass.setForeground(Color.black);
        jlPass.setBounds(15, 120, 150, 30);

        jtfPass.setBounds(100, 120, 150, 30);
    }

    private void setupRadioButton() {
        jrbAdmin.setBounds(60, 165, 80,20);
        jrbUser.setBounds(150, 165,80, 20);

        ButtonGroup bgTypeAcc = new ButtonGroup();
        bgTypeAcc.add(jrbAdmin);
        bgTypeAcc.add(jrbUser);
    }

    private void setupJLStatus() {
        jlStatus.setForeground(Color.red);
        jlStatus.setFont(new Font("arial", Font.ITALIC, 12));
        jlStatus.setBounds(30, 180,200, 30);
    }

    private void setupJBAdd() {
        jbAdd.setBackground(Color.yellow);
        jbAdd.setFont(jbFont);
        jbAdd.setBounds(15, 210, 80, 30);
        jbAdd.addActionListener(updateAccountListener);
    }

    private void setupJBEdit() {
        jbEdit.setBackground(Color.yellow);
        jbEdit.setFont(jbFont);
        jbEdit.setBounds(107, 210,80, 30);
        jbEdit.addActionListener(updateAccountListener);
    }

    private void setupJBDelete() {
        jbDelete.setBackground(Color.yellow);
        jbDelete.setFont(jbFont);
        jbDelete.setBounds(200, 210,80, 30);
        jbDelete.addActionListener(updateAccountListener);
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }

    public JTextField getJtfName() {
        return jtfName;
    }

    public JTextField getJtfPass() {
        return jtfPass;
    }

    public JRadioButton getJrbAdmin() {
        return jrbAdmin;
    }
}
