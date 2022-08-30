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
    private JRadioButton jrbAdmin = new JRadioButton("Admin"), jrbUser = new JRadioButton("User");
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
        this.add(jrbAdmin);
        this.add(jrbUser);
    }

    private void setupComponent() {
        this.setupName();
        this.setupPass();
        this.setupRadioButton();
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
        jbAdd.setLocation(15, 230);
    }
    private void setupRadioButton() {
        jrbAdmin.setSize(80, 20);
        jrbAdmin.setLocation(60, 180);

        jrbUser.setSize(80, 20);
        jrbUser.setLocation(150, 180);

        ButtonGroup bgTypeAcc = new ButtonGroup();
        bgTypeAcc.add(jrbAdmin);
        bgTypeAcc.add(jrbUser);
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
