package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;

public class StartLogin extends JFrame {
    private final int FRAME_WIDTH = 900, FRAME_HIGH = 600;
    private final Font font = new Font("Cambria", Font.BOLD, 30);
    static Image bgImage;
    static JTextField jtfAccount, jtfPass;
    static JPanel JPImage, JPLogin;
    static JLabel JLLogin;
    static JButton JBLogin;

    public StartLogin() {
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
        JPLogin.setLayout(new GridLayout(4, 1, 25, 30));
        JPLogin.setBorder(BorderFactory.createEmptyBorder(150, 600, 200, 50));

        JLLogin = new JLabel("Login!");
        JPLogin.add(JLLogin);
        JLLogin.setFont(font);
        jtfAccount = new JTextField("  Account...");
        jtfPass = new JTextField("  Password...");
        JBLogin = new JButton("Log In");
        JBLogin.setBackground(Color.LIGHT_GRAY);
        JBLogin.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JBLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 50));

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
        new StartLogin();
    }
}
