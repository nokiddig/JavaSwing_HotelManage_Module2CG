package view.login;

import controller.login.LoginListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Login extends JFrame {
    private final int FRAME_WIDTH = 900, FRAME_HIGH = 600;
    private LoginListener loginListener;
    private Image backgroundImage;
    private JTextField jtfAccount;
    private JPasswordField jPasswordField;
    private JPanel jpLogin;
    private JLabel jlLogin, jlNote, jlWelcome;
    private JButton jbLogin;

    public Login() {
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
        loginListener = new LoginListener(this);
        jpLogin = setBackgroundImage("image\\bkGr3.jpg");
        jpLogin.setLayout(null);

        this.setupJLLogin();
        this.setupJTFAccount();
        this.setupJTFPass();
        this.setupJLNote();
        this.setupJLWelcome();
        this.setupJBLogin();

        this.addComponent();
    }

    private void addComponent() {
        jpLogin.add(jlWelcome);
        jpLogin.add(jlLogin);
        jpLogin.add(jtfAccount);
        jpLogin.add(jPasswordField);
        jpLogin.add(jlNote);
        jpLogin.add(jbLogin);
    }

    private void setupJBLogin() {
        jbLogin = new JButton("Log In");
        jbLogin.addActionListener(loginListener);
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
        jPasswordField = new JPasswordField("password");
        jPasswordField.setBounds(600, 250,250,30);
    }

    private void setupJTFAccount() {
        jtfAccount = new JTextField(" Account...");
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

    public  JPanel setBackgroundImage(String src) {
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

    public JPasswordField getjPasswordField() {
        return jPasswordField;
    }

    public JTextField getJtfAccount() {
        return jtfAccount;
    }

    public JLabel getJlNote() {
        return jlNote;
    }
}
