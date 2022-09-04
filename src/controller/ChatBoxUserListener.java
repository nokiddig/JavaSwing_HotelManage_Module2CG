package controller;

import view.adminManager.JPInformation;
import view.userView.JPChatbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBoxUserListener implements ActionListener{
    private final JPChatbox jpChatbox;

    public ChatBoxUserListener(JPChatbox jpChatbox) {
        this.jpChatbox = jpChatbox;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Turnover")) {
            return;
        }
        if (str.equals("Send")) {
            String mes = jpChatbox.getJtaRep().getText();
            jpChatbox.getChatUser().sendMessage("User: " + mes);
            jpChatbox.getJtaRep().setText("");
            return;
        }
    }
}
