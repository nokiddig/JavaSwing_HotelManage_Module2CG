package controller;

import view.login.StartManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartLoginListener implements ActionListener {
    private StartManage startManage;

    public StartLoginListener (StartManage startManage) {
        this.startManage = startManage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getAction = e.getActionCommand();
        if (getAction.equals("Log In")) {
            this.startManage.requestLogin();
        }
        System.out.println("Click");
    }
}
