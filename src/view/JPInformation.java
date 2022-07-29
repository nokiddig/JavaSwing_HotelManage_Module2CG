package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JPInformation extends JPanel {
    private final Font font = new Font("Serif", Font.ITALIC|Font.BOLD, 20);
    public JPInformation () {
        this.init();
    }

    private void init() {
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(BorderFactory.createTitledBorder(border, "Information!",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, font));
    }
}
