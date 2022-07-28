package model.entity;

public class User {
    private String name, pass;
    private int salary = 0;
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public int getSalary() {
        return salary;
    }
}
