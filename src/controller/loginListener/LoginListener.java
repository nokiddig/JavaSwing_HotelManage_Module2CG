package controller.loginListener;

import view.login.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private Login login;

    public LoginListener(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getAction = e.getActionCommand();
        if (getAction.equals("Log In")) {
            this.login.requestLogin();
        }
    }
}
