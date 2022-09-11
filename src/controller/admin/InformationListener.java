package controller.admin;

import model.entity.Account;
import model.entity.Room;
import model.entity.Service;
import model.input.ReadService;
import model.input.ReadWriteAccount;
import model.input.ReadWriteRoom;
import model.input.ReadWriteTurnover;
import view.admin.InformationPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationListener implements ActionListener {
    private final InformationPanel informationPanel;
    private ReadWriteRoom readWriteRoom;
    private ReadService readService;

    public InformationListener(InformationPanel informationPanel) {
        readService = ReadService.getInstance();
        readWriteRoom = ReadWriteRoom.getInstance();
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
        if (str.equals("Data")) {
            String data = " ** Account ** \n";
            for (Account account:ReadWriteAccount.getInstance().getListUser()) {
                data += account.toString();
            }
            data += " ** Room ** \n";
            for (Room room:ReadWriteRoom.getInstance().getListRooms()) {
                data += room.toString();
            }
            data += " ** Service ** \n";
            for (Service service:ReadService.getInstance().getListService()) {
                data += service.toString();
            }
            JOptionPane.showConfirmDialog(null, data, "Data", JOptionPane.DEFAULT_OPTION);
        }
    }

    private void orderService() {
        String nameService = (String) informationPanel.getServiceComboBox().getSelectedItem();
        String iDRoom = informationPanel.getIDTextField().getText();

        int index = readWriteRoom.searchRoom(iDRoom);
        if (index<0 || readWriteRoom.getListRooms().get(index).getStatus().equals("Available")) {
            String message = "Please input ID room which being using.";
            JOptionPane.showConfirmDialog(null, message);
        }
        else {
            int roomServicePay = readWriteRoom.getListRooms().get(index).getServicePay();
            int itemServicePay = readService.getServiceByName(nameService).getPrice();
            String message = "Do you want order " + nameService + " " + itemServicePay + " for room " + iDRoom;

            int answer = JOptionPane.showConfirmDialog(null, message, "Payment", JOptionPane.YES_NO_OPTION);
            int yes = 0;
            if (answer == yes) {
                JOptionPane.showConfirmDialog(null, "Done!", "Payment",JOptionPane.DEFAULT_OPTION);
                readWriteRoom.getListRooms().get(index).setServicePay(roomServicePay + itemServicePay);
            }
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
        ReadWriteTurnover readWriteTurnover = ReadWriteTurnover.getInstance();
        String mes = "Hotel Turnover: " + readWriteTurnover.getTurnOver() + " VND.";
        JOptionPane.showConfirmDialog(null, mes, "Turnover", JOptionPane.CANCEL_OPTION);
    }
}
