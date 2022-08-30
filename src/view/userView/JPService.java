package view.userView;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPService extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    private final Font jlFont = new Font("arial", Font.PLAIN, 16);
    private final Font jbFont = new Font("Arial", Font.BOLD, 14);

    public JPService() {
        this.setupBorder("Hotel service");
        this.setLayout(null);
        this.setupComponent();
        this.addComponent();
    }

    private void addComponent() {
    }

    private void setupComponent() {
    }

    private void setupBorder(String name) {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, name,
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
