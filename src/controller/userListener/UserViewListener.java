package controller.userListener;

import view.userView.JFAllUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewListener implements ActionListener {
    private JFAllUserView JFAllUserView;

    public UserViewListener(JFAllUserView AUV) {
        JFAllUserView = AUV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
