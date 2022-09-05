package controller;

import model.input.ReadWriteTurnover;
import view.adminManager.JPRoom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomListener implements ActionListener {
    private JPRoom jpRoom;
    private ReadWriteTurnover readWriteTurnover = new ReadWriteTurnover();
    public RoomListener(JPRoom jpRoom) {
        this.jpRoom = jpRoom;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        boolean checkEvent = false;
        if (str.equals("Book") && jpRoom.bookRoom()) {
            jpRoom.updateStatusUI();
        }
        if (str.equals("Payment") && jpRoom.payment()) {
            readWriteTurnover.setTurnOver(readWriteTurnover.getTurnOver()+jpRoom.checkBill());
            readWriteTurnover.writeTurnover();
            jpRoom.updateStatusUI();
        }

    }
}
