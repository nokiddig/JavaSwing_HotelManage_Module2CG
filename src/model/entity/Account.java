package model.entity;

public class Account {
    private String name, pass;
    private boolean adminAccount;

    public Account(String n, String p, boolean admin) {
        this.name = n;
        this.pass = p;
        this.adminAccount = admin;
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
