package controller.admin;

import model.input.ReadService;
import model.input.ReadWriteRoom;
import model.input.ReadWriteTurnover;
import view.admin.InformationPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationListener implements ActionListener {
    private final InformationPanel informationPanel;
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();
    private ReadService readService = new ReadService();

    public InformationListener(InformationPanel informationPanel) {
        this.informationPanel = informationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Turnover")) {
            this.showTurnOver();
        }
        if (str.equals("Send")) {
            this.sendAMessage();
        }
        if (str.equals("Clear all")) {
            this.clearJTAText();
        }
        if (str.equals("Refresh")) {
            informationPanel.refreshNotificationTextArea();
        }
        if (str.equals("Order")) {
            this.orderService();
        }
    }

    private void orderService() {
        String nameService = (String) informationPanel.getServiceComboBox().getSelectedItem();
        String iDRoom = informationPanel.getIDTextField().getText();
        readWriteRoom.readListRooms();

        int index = readWriteRoom.searchRoom(iDRoom);
        if (index<0 || readWriteRoom.getListRooms().get(index).getStatus().equals("Available")) {
            String message = "Please input ID room which being using.";
            JOptionPane.showConfirmDialog(null, message);
        }
        else {
            String message = "Order complete but not payment.";
            JOptionPane.showConfirmDialog(null, message);
            readService.readAllService();

        }

    }

    private void clearJTAText() {
        informationPanel.getNotificationTextArea().setText("");
        informationPanel.getRepTextArea().setText("");
    }

    private void sendAMessage() {
        String mes = "Admin: " + informationPanel.getRepTextArea().getText();
        informationPanel.addMessage(mes);
        informationPanel.getChatAdmin().sendMessage(mes);
        informationPanel.getRepTextArea().setText("");
    }

    private void showTurnOver() {
        ReadWriteTurnover readWriteTurnover = new ReadWriteTurnover();
        String mes = "Hotel Turnover: " + readWriteTurnover.getTurnOver() + " VND.";
        JOptionPane.showConfirmDialog(null, mes, "Turnover", JOptionPane.CANCEL_OPTION);
    }
}
