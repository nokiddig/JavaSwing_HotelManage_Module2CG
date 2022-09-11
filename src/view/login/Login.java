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
    private JTextField accountTextField;
    private JPasswordField passwordField;
    private JPanel loginPanel;
    private JLabel loginLabel, noteLabel, welcomeLabel;
    private JButton loginButton;

    public Login() {
        this.setupJFrame();
        this.setupLoginPanel();
        this.add(loginPanel);
        this.setVisible(true);
    }

    private void setupJFrame() {
        this.setTitle("Sun Gem Hotel!");
        this.setLayout(new GridLayout(1, 2));
        this.setSize(FRAME_WIDTH, FRAME_HIGH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setupIcon();
    }

    private void setupIcon() {
        Image iconImage = Toolkit.getDefaultToolkit().createImage("image\\sImage.jpg");
        this.setIconImage(iconImage);
    }

    private void setupLoginPanel() {
        loginListener = new LoginListener(this);
        loginPanel = setBackgroundImage("image\\background.jpg");
        loginPanel.setLayout(null);

        this.setupLoginLabel();
        this.setupAccountTextField();
        this.setupPasswordField();
        this.setupNoteLabel();
        this.setupWelcomeLabel();
        this.setupLoginButton();

        this.addComponent();
    }

    private void addComponent() {
        loginPanel.add(welcomeLabel);
        loginPanel.add(loginLabel);
        loginPanel.add(accountTextField);
        loginPanel.add(passwordField);
        loginPanel.add(noteLabel);
        loginPanel.add(loginButton);
    }

    private void setupLoginButton() {
        loginButton = new JButton("Log In");
        loginButton.addActionListener(loginListener);
        loginButton.setBackground(Color.yellow);
        loginButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        loginButton.setBounds(650, 320,150,30);
    }

    private void setupNoteLabel() {
        noteLabel = new JLabel("");
        noteLabel.setFont( new Font("arial", Font.ITALIC, 14));
        noteLabel.setForeground(Color.red);
        noteLabel.setBounds(600, 280, 150, 30);
    }

    private void setupPasswordField() {
        passwordField = new JPasswordField("password");
        passwordField.setBounds(600, 250,250,30);
        passwordField.addKeyListener(loginListener);
    }

    private void setupAccountTextField() {
        accountTextField = new JTextField(" Account");
        accountTextField.setBounds(600, 200,250,30);
        accountTextField.addKeyListener(loginListener);
    }

    private void setupWelcomeLabel() {
        welcomeLabel = new JLabel("Welcome to SG Hotel!");
        welcomeLabel.setFont(new Font("Cambria", Font.BOLD, 45));
        welcomeLabel.setBounds(230, 10,500,100);
    }

    private void setupLoginLabel() {
        loginLabel = new JLabel("Please log in to use!");
        loginLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        loginLabel.setBounds(600, 120,500,1000);
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

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getAccountTextField() {
        return accountTextField;
    }

    public JLabel getNoteLabel() {
        return noteLabel;
    }
}
