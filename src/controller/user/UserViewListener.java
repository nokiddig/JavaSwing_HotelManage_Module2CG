package controller.user;

import view.user.JFAllUserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewListener implements ActionListener {
    private JFAllUserView jfAllUserView;

    public UserViewListener(JFAllUserView AUV) {
        jfAllUserView = AUV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Quit")) {
            String mes = "You want quit?";
            int asw = JOptionPane.showConfirmDialog(null, mes, "Quit", JOptionPane.YES_NO_OPTION);
            final int yes = 0;
            if (asw == yes)
                jfAllUserView.quitApp();
        }
    }
}
