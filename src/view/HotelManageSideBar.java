package view;

import javax.swing.*;
import java.awt.*;

public class HotelManageSideBar extends JPanel {
    private JPanel jpInfo = new JPanel();
    private JPanel jpUpdate = new JPanel();

    public HotelManageSideBar() {
        this.init();
    }

    private void init () {
        this.setLayout(new GridLayout(2, 1));
        this.setupJPUpdate();
        this.add(jpUpdate);
        this.add(jpInfo);
    }

    private void setupJPUpdate() {
        jpUpdate.add(new JLabel(""));
    }

}
