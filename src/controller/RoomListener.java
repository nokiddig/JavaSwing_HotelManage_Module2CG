package controller;

import view.adminManager.JPRoom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomListener implements ActionListener {
    private JPRoom jpRoom;
    public RoomListener(JPRoom jpRoom) {
        this.jpRoom = jpRoom;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        boolean checkEvent = false;
        if (str.equals("Book")) {

        }
        if (str.equals("Book")) {

        }
        if (! checkEvent) {
            jpRoom.updateStatusUI();
        }
    }
}
