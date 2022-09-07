package controller.userListener;

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
        if (str.equals("Send")) {
            String mes = jpChatbox.getNameUser() + ": " + jpChatbox.getJtaRep().getText();
            jpChatbox.addMessage(mes);
            jpChatbox.getChatUser().sendMessage(mes);
            jpChatbox.getJtaRep().setText("");
        }
        if (str.equals("Clear all")){
            jpChatbox.getJtaRep().setText("");
            jpChatbox.getJtaNoti().setText("");
        }
        if (str.equals("Refresh")) {
            jpChatbox.refreshJTANoti();
        }
    }
}
