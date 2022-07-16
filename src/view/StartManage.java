package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartManage extends JFrame {
    private final int FRAME_WIDTH = 900, FRAME_HIGH = 600;
    private final Font font = new Font("Cambria", Font.BOLD, 30);
    static Image bgImage;
    static JTextField jtfAccount, jtfPass;
    static JPanel JPImage, JPLogin;
    static JLabel JLLogin;
    static JButton JBLogin;

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

        this.setupJPLogin();
        this.add(JPLogin);
        this.setVisible(true);
    }

    private void setupJPLogin() {
        JPLogin = setBackgroundJPanel(this.JPLogin, "image\\bkGr3.jpg");
        JPLogin.setLayout(null);

        JLLogin = new JLabel("SG Hotel!");
        JLLogin.setFont(font);
        JLLogin.setSize(200, 100);
        JLLogin.setLocation(660, 100);

        jtfAccount = new JTextField("  Account...");
        jtfAccount.setSize(180, 30);
        jtfAccount.setLocation(650, 200);

        jtfPass = new JTextField("  Password...");
        jtfPass.setSize(180, 30);
        jtfPass.setLocation(650, 250);

        JBLogin = new JButton("Log In");
        JBLogin.setBackground(Color.LIGHT_GRAY);
        JBLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JBLogin.setSize(100, 30);
        JBLogin.setLocation(675, 300);

        JPLogin.add(JLLogin);
        JPLogin.add(jtfAccount);
        JPLogin.add(jtfPass);
        JPLogin.add(JBLogin);
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
//        Font font = new Font("Cambria", Font.BOLD, 30);
//        if (jb instanceof JButton) {
//            jb.setFont(font);
//            jb.setForeground(Color.DARK_GRAY);
//            jb.setBackground(Color.orange);
//        }
    }

    public static void main(String[] args) {
        new StartManage();
    }
}
