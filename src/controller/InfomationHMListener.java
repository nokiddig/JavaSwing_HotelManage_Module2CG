package controller;

import view.adminManager.JPInformation;

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
            return;
        }
        if (str.equals("Send")) {
            String mes = jpInformation.getJtaRep().getText();
            jpInformation.getChatAdmin().sendMessage("Admin: " + mes);
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
