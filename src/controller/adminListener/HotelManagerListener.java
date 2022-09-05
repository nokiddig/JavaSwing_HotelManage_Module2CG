package controller.adminListener;

import view.adminManager.JFHotelManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagerListener implements ActionListener {
    private JFHotelManagement JFHotelManagement;

    public HotelManagerListener(JFHotelManagement JFHotelManagement) {
        this.JFHotelManagement = JFHotelManagement;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Quit")) {
            String mes = "You want quit?";
            int asw = JOptionPane.showConfirmDialog(null, mes, "Quit", JOptionPane.YES_NO_OPTION);
            final int yes = 0;
            if (asw == yes)
                JFHotelManagement.quitApp();
        }
    }
}
