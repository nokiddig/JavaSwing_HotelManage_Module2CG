package controller;

import view.adminManager.HotelManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagerListener implements ActionListener {
    private HotelManagement hotelManagement;

    public HotelManagerListener(HotelManagement hotelManagement) {
        this.hotelManagement = hotelManagement;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Quit")) {
            hotelManagement.quitApp();
        }
    }
}
