package view.login;

import controller.StartLoginListener;
import model.entity.Account;
import fileReadWrite.ReadWriteAccount;
import view.adminManager.HotelManagement;
import view.userView.AllUserView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartManage extends JFrame {
    private final int FRAME_WIDTH = 900, FRAME_HIGH = 600;

    private JFrame userView;
    private StartLoginListener listener;
    private static Image backgroundImage;
    private static JTextField jtfAccount, jtfPass;
    private static JPanel jpLogin;
    private static JLabel jlLogin, jlNote, jlWelcome;
    private static JButton jbLogin;

    private ReadWriteAccount readWriteAccount = new ReadWriteAccount();
    public StartManage() {
        this.init();
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
        this.setupJLWelcome();
        this.setupJBLogin();

        jpLogin.add(jlWelcome);
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
        jbLogin.setBounds(650, 320,150,30);
    }
    private void setupJLNote() {
        jlNote = new JLabel("");
        jlNote.setFont( new Font("arial", Font.ITALIC, 14));
        jlNote.setForeground(Color.red);
        jlNote.setBounds(600, 280, 150, 30);
    }
    private void setupJTFPass() {
        jtfPass = new JTextField("  Password...");
        jtfPass.setBounds(600, 250,250,30);
    }
    private void setupJTFAccount() {
        jtfAccount = new JTextField("  Account...");
        jtfAccount.setBounds(600, 200,250,30);
    }
    private void setupJLWelcome() {
        jlWelcome = new JLabel("Welcome to SG Hotel!");
        jlWelcome.setFont(new Font("Cambria", Font.BOLD, 45));
        jlWelcome.setBounds(230, 10,500,100);
    }
    private void setupJLLogin() {
        jlLogin = new JLabel("Please log in to use!");
        jlLogin.setFont(new Font("Arial", Font.PLAIN, 25));
        jlLogin.setBounds(600, 120,500,1000);
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
        String name = this.jtfAccount.getText().trim(), pass = this.jtfPass.getText().trim();

        for (Account account : readWriteAccount.getListUser()) {
            if (name.equals(account.getName()) && pass.equals(account.getPass())) {
                this.setVisible(false);
                if (account.getAdminAccount()){
                    this.userView = new HotelManagement(name);
                }
                else {
                    this.userView = new AllUserView();
                }
                return;
            }
        }
        this.jlNote.setText(" * Invalid account...");
    }

    public static void main(String[] args) {
        new StartManage();
    }
}
