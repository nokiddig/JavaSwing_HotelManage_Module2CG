package controller.login;

import model.entity.Account;
import model.input.ReadWriteAccount;
import view.admin.HotelManageFrame;
import view.login.Login;
import view.user.UserViewFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginListener implements ActionListener, KeyListener {
    private Login login;
    private final ReadWriteAccount readWriteAccount;

    public LoginListener(Login login) {
        readWriteAccount = ReadWriteAccount.getInstance();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            requestLogin();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}