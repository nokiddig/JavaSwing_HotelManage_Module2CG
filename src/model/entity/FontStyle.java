package model.entity;

import java.awt.*;

public enum FontStyle {
    FONT_BORDER,
    FONT_BUTTON,
    FONT_LABEL;

    private static final Font border = new java.awt.Font("Serif", java.awt.Font.ITALIC| java.awt.Font.BOLD, 20);
    private static final Font button = new java.awt.Font("Arial", java.awt.Font.BOLD, 14);
    private static final Font label = new java.awt.Font("times new roman", java.awt.Font.ITALIC, 16);

    public Font getFont() {
        switch(this) {
            case FONT_BORDER:
                return border;
            case FONT_BUTTON:
                return button;
            case FONT_LABEL:
                return label;
            default:
                return null;
        }
    }
}
