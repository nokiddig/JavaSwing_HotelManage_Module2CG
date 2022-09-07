package model.input;

import javax.swing.*;

public class Validate {

    public boolean checkAccount(String name, String pass) {
        return checkUserName(name) && checkPassword(pass);
    }

    public boolean checkRoom(String id, String large, String noBed, String price) {
        return checkIDRoom(id) && checkLarge(large) && checkBed(noBed) && checkPrice(price);
    }

    public void showHandleRoom() {
        String handleRoom = "Room ID: must be 3 number (ex: 001)\n" +
                "Large: about 10 to 99 m2 \n" +
                "NO bed: 0 - 4\n" +
                "Price: from 100000 for 1 day\n" +
                "If you want edit room, Room ID is exist and status must available.";
        JOptionPane.showMessageDialog(null, handleRoom);
    }

    public void showHandleAccount() {
        String handleAccount = "Name: 3-15 characters (0-9 or a-z or A-Z)\n" +
                "Password: 3-15 characters (0-9 or a-z or A-Z)\n" +
                "Can't creat an account existed, can't edit account being used.";
        JOptionPane.showMessageDialog(null, handleAccount);
    }

    public boolean checkPassword(String pass) {
        String passwordRegex = "[\\dA-Za-z]{3,15}";
        return pass.matches(passwordRegex);
    }

    public boolean checkUserName(String name) {
        String userNameRegex = "[\\dA-Za-z]{3,15}";
        return name.matches(userNameRegex);
    }

    public boolean checkLarge(String large) {
        String largeRegex = "\\d{1,3}";
        return large.matches(largeRegex);
    }

    public boolean checkBed(String noBed) {
        String noBedRegex = "[01234]";
        return noBed.matches(noBedRegex);
    }

    public boolean checkPrice(String price) {
        String priceRegex = "[1-9]\\d{5,7}";
        return price.matches(priceRegex);
    }

    public boolean checkIDRoom(String ID) {
        String IDRegex = "\\d{3}";
        return ID.matches(IDRegex);
    }
}
