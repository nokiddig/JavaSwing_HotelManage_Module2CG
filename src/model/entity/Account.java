package model.entity;

public class Account {
    private String name, pass;
    private boolean adminAccount;

    public Account(String name, String pass, boolean admin) {
        this.name = name;
        this.pass = pass;
        this.adminAccount = admin;
    }

    @Override
    public String toString() {
        return  "name: " + name +", pass: " + pass + ", type: " + (adminAccount?"Admin":"User") + "\n";
    }

    public boolean getAdminAccount() {
        return adminAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public void setAdminAccount(boolean adminAccount) {
        this.adminAccount = adminAccount;
    }
}
