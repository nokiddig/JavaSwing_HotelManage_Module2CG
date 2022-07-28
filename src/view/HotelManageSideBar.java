package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class HotelManageSideBar extends JPanel {
    private JPanel jpInfo = new JPanel();
    private JPanel jpUpdate = new JPanel();
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    public HotelManageSideBar() {
        this.init();
    }

    private void init () {
        this.setLayout(new GridLayout(1, 2));

        this.setupJPUpdate();
        this.setupJPInfo();

        this.add(jpUpdate);
        this.add(jpInfo);
    }

    private void setupJPUpdate() {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        jpUpdate.setBorder(BorderFactory.createTitledBorder(border, "Update information!",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));

    }
    private void setupJPInfo() {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        jpInfo.setBorder(BorderFactory.createTitledBorder(border, "Information!",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
