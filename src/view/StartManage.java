package view;

import controller.StartLoginListener;
import model.entity.User;
import model.fileReadWrite.ReadWriteUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class StartManage extends JFrame {
    private final int FRAME_WIDTH = 900, FRAME_HIGH = 600;

    private HotelManagement hotelManagement;
    private StartLoginListener listener;
    private static Image backgroundImage;
    private static JTextField jtfAccount, jtfPass;
    private static JPanel jpLogin;
    private static JLabel jlLogin, jlNote;
    private static JButton jbLogin;

    private ReadWriteUser readWriteUser = new ReadWriteUser();

    public StartManage() {
        this.init();
        System.out.println(java.time.LocalDate.now());
    }



    public void init() {
        this.setTitle("Sun Gem Hotel!");
        this.setLayout(new GridLayout(1, 2));
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setupLogin();
        this.add(jpLogin);
        this.setVisible(true);
    }
    private void setupLogin() {
        listener = new StartLoginListener(this);
        jpLogin = setBackgroundImage(this.jpLogin, "image\\bkGr3.jpg");
        jpLogin.setLayout(null);

        this.setupJLLogin();
        this.setupJTFAccount();
        this.setupJTFPass();
        this.setupJLNote();
        this.setupJBLogin();

        jpLogin.add(jlLogin);
        jpLogin.add(jtfAccount);
        jpLogin.add(jtfPass);
        jpLogin.add(jlNote);
        jpLogin.add(jbLogin);
    }

    private void setupJBLogin() {
        jbLogin = new JButton("Log In");
        jbLogin.addActionListener(listener);
        jbLogin.setBackground(Color.yellow);
        jbLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        jbLogin.setSize(150, 30);
        jbLogin.setLocation(650, 320);
    }

    private void setupJLNote() {
        jlNote = new JLabel("");
        jlNote.setFont( new Font("arial", Font.ITALIC, 14));
        jlNote.setForeground(Color.red);
        jlNote.setSize(150, 30);
        jlNote.setLocation(600, 280);
    }

    private void setupJTFPass() {
        jtfPass = new JTextField("  Password...");
        jtfPass.setSize(250, 30);
        jtfPass.setLocation(600, 250);
    }

    private void setupJTFAccount() {
        jtfAccount = new JTextField("  Account...");
        jtfAccount.setSize(250, 30);
        jtfAccount.setLocation(600, 200);
    }

    private void setupJLLogin() {
        jlLogin = new JLabel("SG Hotel!");
        jlLogin.setFont(new Font("Cambria", Font.BOLD, 40));
        jlLogin.setSize(250, 100);
        jlLogin.setLocation(600, 100);
    }

    public  JPanel setBackgroundImage(JPanel jp, String src) {
        File fileImage = new File(src);
        try {
            backgroundImage = ImageIO.read(fileImage);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                g.drawImage(backgroundImage,0,0,null);
            }
        };
    }

    public void requestLogin() {
        String name = this.jtfAccount.getText(), pass = this.jtfPass.getText();
        name = name.trim();
        pass = pass.trim();

        for (User u:readWriteUser.getListUser()) {
            if (name.equals(u.getName()) && pass.equals(u.getPass())) {
                this.setVisible(false);
                this.hotelManagement = new HotelManagement();
                return;
            }
        }
        this.jlNote.setText(" * Invalid account...");
    }

    public static void main(String[] args) {
        new StartManage();
    }
}
