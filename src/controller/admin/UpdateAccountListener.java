package controller.admin;

import model.input.ReadWriteAccount;
import model.entity.Account;
import model.input.Validate;
import view.admin.UpdateAccountPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAccountListener implements ActionListener {
    private UpdateAccountPanel updateAccountPanel;
    private ReadWriteAccount readWriteAccount = new ReadWriteAccount();
    private Validate validate = new Validate();

    public UpdateAccountListener(UpdateAccountPanel updateAccountPanel) {
        this.updateAccountPanel = updateAccountPanel;
        readWriteAccount.readListUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        String name = updateAccountPanel.getNameTextField().getText();
        String pass = updateAccountPanel.getPasswordTextField().getText();
        boolean admin = updateAccountPanel.getAdminRadioButton().isSelected();

        startCRUD:
        if (validate.checkAccount(name, pass)){
            int notFound = -1;
            if (str.equals("Delete")) {
                if (readWriteAccount.searchAccount(name) == notFound) {
                    JOptionPane.showMessageDialog(null, "user name not found!");
                    break startCRUD;
                }
                else {
                    readWriteAccount.deleteAccount(name);
                }
            }
            if (str.equals("Edit")){
                if (readWriteAccount.searchAccount(name) == notFound) {
                    JOptionPane.showMessageDialog(null, "user name not found!");
                    break startCRUD;
                }
                else {
                    Account account = new Account(name, pass, admin);
                    readWriteAccount.editAccount(account);
                }
            }
            if (str.equals("Add")) {
                if (readWriteAccount.searchAccount(name) != notFound) {
                    JOptionPane.showMessageDialog(null, "user name existed!");
                    break startCRUD;
                }
                else {
                    Account account = new Account(name, pass, admin);
                    readWriteAccount.addAccount(account);
                }
            }
            JOptionPane.showMessageDialog(null, "Done!!");
        }
        else {
            validate.showHandleAccount();
        }
    }
}
