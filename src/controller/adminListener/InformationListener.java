package controller.adminListener;

import model.input.ReadWriteTurnover;
import view.adminManager.JPInformation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationListener implements ActionListener {
    private final JPInformation jpInformation;

    public InformationListener(JPInformation jpInformation) {
        this.jpInformation = jpInformation;
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
            jpInformation.refreshJTANoti();
        }
    }

    private void clearJTAText() {
        jpInformation.getJtaNoti().setText("");
        jpInformation.getJtaRep().setText("");
    }

    private void sendAMessage() {
        String mes = "Admin: " + jpInformation.getJtaRep().getText();
        jpInformation.addMessage(mes);
        jpInformation.getChatAdmin().sendMessage(mes);
        jpInformation.getJtaRep().setText("");
    }

    private void showTurnOver() {
        ReadWriteTurnover readWriteTurnover = new ReadWriteTurnover();
        String mes = "Hotel Turnover: " + readWriteTurnover.getTurnOver() + " VND.";
        JOptionPane.showConfirmDialog(null, mes, "Turnover", JOptionPane.CANCEL_OPTION);
    }
}
