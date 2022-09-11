package controller.admin;

import model.entity.Account;
import model.input.ReadWriteAccount;
import model.input.ReadWriteRoom;
import model.input.ReadWriteTurnover;
import view.admin.ARoomPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

public class RoomListener implements ActionListener {
    private ARoomPanel aRoomPanel;
    private ReadWriteTurnover readWriteTurnover;
    private ReadWriteRoom readWriteRoom;

    public RoomListener(ARoomPanel aRoomPanel) {
        readWriteTurnover = ReadWriteTurnover.getInstance();
        readWriteRoom = ReadWriteRoom.getInstance();
        this.aRoomPanel = aRoomPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Book") && this.bookRoom()) {
            aRoomPanel.updateStatusUI();
        }
        if (str.equals("Payment") && this.payment()) {
            long newTurnover = readWriteTurnover.getTurnOver() + this.checkBill();
            readWriteTurnover.setTurnOver(newTurnover);
            readWriteTurnover.writeTurnover();
            aRoomPanel.updateStatusUI();
        }
    }

    public boolean bookRoom() {
        String showQuestion = "Input user-name to book: ";
        String userName = (String) JOptionPane.showInputDialog(null,showQuestion,"Book Room",JOptionPane.PLAIN_MESSAGE,null,null,"syNgoc");

        if ((userName != null) && (userName.length() > 0)) {
            ReadWriteAccount readWriteAccount = ReadWriteAccount.getInstance();

            for (Account a:readWriteAccount.getListUser()) {
                if (a.getName().equals(userName)) {
                    aRoomPanel.getRoom().setStatus(userName);
                    aRoomPanel.updateStatusUI();
                    aRoomPanel.getRoom().setStartDate(java.time.LocalDate.now().toString());
                    readWriteRoom.editRoom(aRoomPanel.getRoom());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean payment() {
        String mes = "Would you want to payment " + checkBill() + " vnd for room " +
                aRoomPanel.getRoom().getRoomID() + "?" + "\n - User: " +
                aRoomPanel.getRoom().getStatus() + "\n - From: " +
                aRoomPanel.getRoom().getStartDate();
        int asw = JOptionPane.showConfirmDialog(null, mes, "Payment", JOptionPane.YES_NO_OPTION);

        int yes = 0;
        if (asw == yes) {
            aRoomPanel.getRoom().setStatus("Available");
            readWriteRoom = ReadWriteRoom.getInstance();
            readWriteRoom.editRoom(aRoomPanel.getRoom());
            return true;
        }
        else {
            return false;
        }
    }

    public long checkBill() {
        Calendar firstDay = Calendar.getInstance();
        Calendar lastDay = Calendar.getInstance();
        firstDay.setTime(Date.valueOf(aRoomPanel.getRoom().getStartDate()));
        lastDay.setTime(Date.valueOf(java.time.LocalDate.now()));
        long noDay = ((lastDay.getTime().getTime() - firstDay.getTime().getTime()) / (24 * 3600 * 1000));
        return (noDay+1)*aRoomPanel.getRoom().getPrice() + aRoomPanel.getRoom().getServicePay();
    }
}
