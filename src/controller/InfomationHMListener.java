package controller;

import model.input.ReadWriteTurnover;
import view.adminManager.JPInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfomationHMListener implements ActionListener {
    private final JPInformation jpInformation;

    public InfomationHMListener(JPInformation jpInformation) {
        this.jpInformation = jpInformation;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Turnover")) {
            ReadWriteTurnover readWriteTurnover = new ReadWriteTurnover();
            String mes = "Hotel Turnover: " + readWriteTurnover.getTurnOver() + " VND.";
            JOptionPane.showConfirmDialog(null, mes, "Turnover", JOptionPane.CANCEL_OPTION);

            return;
        }
        if (str.equals("Send")) {
            String mes = "Admin: " + jpInformation.getJtaRep().getText();
            jpInformation.addMessage(mes);
            jpInformation.getChatAdmin().sendMessage(mes);
            jpInformation.getJtaRep().setText("");
            return;
        }
        if (str.equals("Clear all")) {
            jpInformation.getJtaNoti().setText("");
            jpInformation.getJtaRep().setText("");
            return;
        }
        if (str.equals("Refresh")) {
            return;
        }
        if (str.equals("Order")) {
            return;
        }
        if (str.equals("Check")) {
            return;
        }
    }
}
