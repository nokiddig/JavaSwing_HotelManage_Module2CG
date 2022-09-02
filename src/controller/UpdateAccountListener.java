package controller;

import fileReadWrite.ReadWriteAccount;
import model.entity.Account;
import view.adminManager.JPUpdateAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAccountListener implements ActionListener {
    private JPUpdateAccount jpUpdateAccount;
    private ReadWriteAccount readWriteAccount = new ReadWriteAccount();

    public UpdateAccountListener(JPUpdateAccount jpUpdateAccount) {
        this.jpUpdateAccount = jpUpdateAccount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        String name = jpUpdateAccount.getJtfName().getText();
        String pass = jpUpdateAccount.getJtfPass().getText();
        boolean admin = jpUpdateAccount.getJrbAdmin().isSelected();
        Account account = new Account(name, pass, admin);

        if (name.equals("")) {
            jpUpdateAccount.getJlStatus().setText(" * Input name to use this feature");
            return;
        }
        if (str.equals("Edit")){
            readWriteAccount.editAccount(account);
        }
        if (str.equals("Delete")) {
            readWriteAccount.deleteAccount(account);
        }
        if (str.equals("Add")) {
            readWriteAccount.addAccount(account);
        }
    }
}
