package controller.admin;

import view.admin.HotelManageFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HotelManagerListener implements ActionListener {
    private HotelManageFrame hotelManageFrame;

    public HotelManagerListener(HotelManageFrame hotelManageFrame) {
        this.hotelManageFrame = hotelManageFrame;
        this.addClosingEvent();
    }

    private void addClosingEvent() {
        hotelManageFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String mes = "Closing... Saving data.";
                JOptionPane.showConfirmDialog(null, mes, "Quit", JOptionPane.DEFAULT_OPTION);
                hotelManageFrame.quitApp();
                super.windowClosing(e);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Quit")) {
            String mes = "You want quit?";
            int asw = JOptionPane.showConfirmDialog(null, mes, "Quit", JOptionPane.YES_NO_OPTION);
            final int yes = 0;
            if (asw == yes)
                hotelManageFrame.quitApp();
        }
    }
}
