package view.adminManager;

import com.sun.javafx.font.FontFactory;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPUpdate extends JPanel {
    private JPanel jpUpdateRoom = new JPUpdateRoom();
    private JPanel jpUpdateAccount = new JPUpdateAccount();

    public JPUpdate () {
        this.init();
    }

    private void init() {
        this.setLayout(new GridLayout(2, 1));
        this.add(jpUpdateAccount);
        this.add(jpUpdateRoom);
    }
}
