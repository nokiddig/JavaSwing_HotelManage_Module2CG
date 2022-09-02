package controller;

import view.userView.AllUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewListener implements ActionListener {
    private AllUserView allUserView;

    public UserViewListener(AllUserView AUV) {
        allUserView = AUV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
