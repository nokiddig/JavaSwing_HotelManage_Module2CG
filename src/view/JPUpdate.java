package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPUpdate extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);

    public JPUpdate () {
        this.init();
    }

    private void init() {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, "Update information!",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));

        this.setLayout(new GridLayout(3, 1));

    }
}
