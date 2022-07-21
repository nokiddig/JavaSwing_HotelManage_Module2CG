package view;

import controller.StartLoginListener;
import model.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class StartManage extends JFrame {
    private final int FRAME_WIDTH = 900, FRAME_HIGH = 600;

    private HotelManagement hotelManagement;
    private StartLoginListener listener;
    private static Image bgImage;
    private static JTextField jtfAccount, jtfPass;
    private static JPanel jpLogin;
    private static JLabel jlLogin, jlNote;
    private static JButton jbLogin;

    private ArrayList<User> listUser = new ArrayList<User>();

    public StartManage() {
        this.readListUser();
        this.init();
    }

    private void readListUser() {
        try {
            File f = new File("fileIO\\Account\\fileAdmin.txt");
            BufferedReader bufferedReader = Files.newBufferedReader(f.toPath(),
                                            StandardCharsets.UTF_8);
            do{
                String name = bufferedReader.readLine();
                String pass = bufferedReader.readLine();
                if (name != null && pass != null) {
                    User user = new User(name, pass, true);
                    listUser.add(user);
                }
                else {
                    break;
                }
            }
            while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jpLogin = setBackgroundJPanel(this.jpLogin, "image\\bkGr3.jpg");
        jpLogin.setLayout(null);

        jlLogin = new JLabel("SG Hotel!");
        jlLogin.setFont(new Font("Cambria", Font.BOLD, 40));
        jlLogin.setSize(250, 100);
        jlLogin.setLocation(600, 100);

        jtfAccount = new JTextField("  Account...");
        jtfAccount.setSize(250, 30);
        jtfAccount.setLocation(600, 200);

        jtfPass = new JTextField("  Password...");
        jtfPass.setSize(250, 30);
        jtfPass.setLocation(600, 250);

        jlNote = new JLabel("");
        jlNote.setFont( new Font("arial", Font.ITALIC, 14));
        jlNote.setForeground(Color.red);
        jlNote.setSize(150, 30);
        jlNote.setLocation(600, 280);

        jbLogin = new JButton("Log In");
        jbLogin.addActionListener(listener);
        jbLogin.setBackground(Color.LIGHT_GRAY);
        jbLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        jbLogin.setSize(150, 30);
        jbLogin.setLocation(650, 320);

        jpLogin.add(jlLogin);
        jpLogin.add(jtfAccount);
        jpLogin.add(jtfPass);
        jpLogin.add(jlNote);
        jpLogin.add(jbLogin);
    }

    private JPanel setBackgroundJPanel(JPanel jp, String src) {
        File fImage = new File(src);
        try {
            bgImage = ImageIO.read(fImage);
        }catch (Exception e) {
            e.printStackTrace();
        }
        jp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                g.drawImage(bgImage,0,0,null);
            }
        };
        return jp;
    }

    public void requestLogin() {
        String name = this.jtfAccount.getText(), pass = this.jtfPass.getText();
        name = name.trim();
        pass = pass.trim();

        for (User u:listUser) {
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
