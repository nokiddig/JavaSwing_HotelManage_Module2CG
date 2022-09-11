package controller.user;

import view.user.UserViewFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewListener implements ActionListener {
    private UserViewFrame userViewFrame;

    public UserViewListener(UserViewFrame userViewFrame) {
        this.userViewFrame = userViewFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Quit")) {
            String mes = "You want quit?";
            int asw = JOptionPane.showConfirmDialog(null, mes, "Quit", JOptionPane.YES_NO_OPTION);
            final int yes = 0;
            if (asw == yes)
                this.quitApp();
        }
    }

    public void quitApp() {
        userViewFrame.getChatboxPanel().getChatUser().setRun(false);
        userViewFrame.getChatboxPanel().getChatUser().closePort();
        userViewFrame.dispose();
    }
}
