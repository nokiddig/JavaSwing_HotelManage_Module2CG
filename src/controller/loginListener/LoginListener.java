package controller.loginListener;

import model.entity.Account;
import model.input.ReadWriteAccount;
import view.adminManager.JFHotelManagement;
import view.login.Login;
import view.userView.JFAllUserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private Login login;
    private final ReadWriteAccount readWriteAccount = new ReadWriteAccount();

    public LoginListener(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String getAction = e.getActionCommand();
        if (getAction.equals("Log In")) {
            this.requestLogin();
        }
    }

    public void requestLogin() {
        String name = login.getJtfAccount().getText().trim(), pass = new String(login.getjPasswordField().getPassword());
        for (Account account : readWriteAccount.getListUser()) {
            if (name.equals(account.getName()) && pass.equals(account.getPass())) {
                login.setVisible(false);
                if (account.getAdminAccount()){
                    new JFHotelManagement(name);
                    login.dispose();
                }
                else {
                    new JFAllUserView(name);
                    login.dispose();
                }
                return;
            }
        }
        login.getJlNote().setText(" * Invalid account...");
    }
}
