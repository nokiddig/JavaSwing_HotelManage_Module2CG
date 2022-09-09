package controller.login;

import model.entity.Account;
import model.input.ReadWriteAccount;
import view.admin.HotelManageFrame;
import view.login.Login;
import view.user.UserViewFrame;

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
        String name = login.getAccountTextField().getText().trim(), pass = new String(login.getPasswordField().getPassword());
        readWriteAccount.readListUser();
        for (Account account : readWriteAccount.getListUser()) {
            if (name.equals(account.getName()) && pass.equals(account.getPass())) {
                login.setVisible(false);
                if (account.getAdminAccount()){
                    new HotelManageFrame(name);
                    login.dispose();
                }
                else {
                    new UserViewFrame(name);
                    login.dispose();
                }
                return;
            }
        }
        login.getNoteLabel().setText(" * Invalid account...");
    }
}
