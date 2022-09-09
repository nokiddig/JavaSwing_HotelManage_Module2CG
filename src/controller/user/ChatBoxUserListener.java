package controller.user;

import view.user.ChatboxPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBoxUserListener implements ActionListener{
    private final ChatboxPanel chatboxPanel;

    public ChatBoxUserListener(ChatboxPanel chatboxPanel) {
        this.chatboxPanel = chatboxPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Send")) {
            String mes = chatboxPanel.getNameUser() + ": " + chatboxPanel.getRepTextArea().getText();
            chatboxPanel.addMessage(mes);
            chatboxPanel.getChatUser().sendMessage(mes);
            chatboxPanel.getRepTextArea().setText("");
        }
        if (str.equals("Clear all")){
            chatboxPanel.getRepTextArea().setText("");
            chatboxPanel.getNotificationTextArea().setText("");
        }
        if (str.equals("Refresh")) {
            chatboxPanel.refreshNotificationTextArea();
        }
    }
}
