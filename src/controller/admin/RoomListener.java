package controller.admin;

import model.input.ReadWriteTurnover;
import view.admin.ARoomPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomListener implements ActionListener {
    private ARoomPanel aRoomPanel;
    private ReadWriteTurnover readWriteTurnover;
    public RoomListener(ARoomPanel aRoomPanel) {
        readWriteTurnover = ReadWriteTurnover.getInstance();
        this.aRoomPanel = aRoomPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Book") && aRoomPanel.bookRoom()) {
            aRoomPanel.updateStatusUI();
        }
        if (str.equals("Payment") && aRoomPanel.payment()) {
            long newTurnover = readWriteTurnover.getTurnOver()+ aRoomPanel.checkBill();
            readWriteTurnover.setTurnOver(newTurnover);
            readWriteTurnover.writeTurnover();
            aRoomPanel.updateStatusUI();
        }
    }
}
