package model;

public class User {
    private String name, pass;
    private boolean adminAccount = false;
    public User(String n, String p, boolean admin) {
        this.name = n;
        this.pass = p;
        this.adminAccount = admin;
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
}
