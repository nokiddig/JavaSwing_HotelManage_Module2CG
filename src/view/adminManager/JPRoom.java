package view.adminManager;

import controller.RoomListener;
import fileReadWrite.ReadWriteAccount;
import fileReadWrite.ReadWriteRoom;
import model.entity.Account;
import model.entity.Room;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Date;
import java.util.Calendar;

public class JPRoom extends JPanel {
    private JLabel jlID = new JLabel("0");
    private JLabel jlLarge = new JLabel("0");
    private JLabel jlBed = new JLabel("0");
    private JLabel jlStatus = new JLabel("0");
    private JLabel jlPrice = new JLabel("0");
    private JButton jbBook = new JButton("Book");
    private Room room;
    private RoomListener roomListener = new RoomListener(this);
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();

    public JPRoom (Room room) {
        this.room = room;
        this.init();
    }
    private void init() {
        Border border = BorderFactory.createLineBorder(Color.black, 1, true);
        Border border1 = BorderFactory.createEmptyBorder(10, 10,10,10);
        Border border2 = BorderFactory.createCompoundBorder(border, border1);
        this.setBorder(border2);
        this.setLayout(new GridLayout(6, 1));

        this.setupJButtonBook();
        this.showInfoRoom();

        this.add(this.jlID);
        this.add(this.jlLarge);
        this.add(this.jlBed);
        this.add(this.jlPrice);
        this.add(this.jlStatus);
        this.add(jbBook);
    }
    public void showInfoRoom() {
        this.jlID.setText("ID: " + room.getRoomID());
        this.jlLarge.setText("Large: " + room.getLarge());
        this.jlBed.setText("Num of bed: " + room.getBed());
        this.jlPrice.setText("Price: " + room.getPrice());
        this.jlStatus.setText(this.room.getStatus());
        jlStatus.setForeground(room.getStatus().equals("Available")?Color.green:Color.red);
    }
    public void updateStatusUI() {
        if (!room.getStatus().equals("Available")) {
            jlStatus.setText(room.getStatus());
            jlStatus.setForeground(Color.red);
            jbBook.setText("Payment");
        }
        else {
//            room.setStatus("Not Available");
            jlStatus.setText("Available");
            jlStatus.setForeground(Color.green);
            jbBook.setText("Book");
        }
    }
    public void setupJButtonBook () {
        jbBook.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        jbBook.setBackground(Color.gray);
        jbBook.addActionListener(roomListener);
        this.updateStatusUI();
    }
    public boolean bookRoom() {
        String showQuestion = "Input user-name to book: ";
        String userName = (String) JOptionPane.showInputDialog(null,showQuestion,"Book Room",JOptionPane.PLAIN_MESSAGE,null,null,"syNgoc");

        if ((userName != null) && (userName.length() > 0)) {
            ReadWriteAccount rwAcc = new ReadWriteAccount();
            for (Account a:rwAcc.getListUser()) {
                if (a.getName().equals(userName)) {
                    this.room.setStatus(userName);
                    this.updateStatusUI();
                    this.room.setStartDate(java.time.LocalDate.now().toString());
                    readWriteRoom.editRoom(this.room);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean payment() {
        String mes = "Would you want to payment " + checkBill() + " vnd for room " + this.room.getRoomID() + "?";
        mes += "\n - User: " + room.getStatus() + "\n - From: " + room.getStartDate();
        int asw = JOptionPane.showConfirmDialog(null, mes, "Payment", JOptionPane.YES_NO_OPTION);
        int yes = 0;
        if (asw == yes) {
            room.setStatus("Available");
            readWriteRoom.editRoom(this.room);
            return true;
        }
        else {
            return false;
        }
    }
    public long checkBill() {
        Calendar firstDay = Calendar.getInstance();
        Calendar lastDay = Calendar.getInstance();
        firstDay.setTime(Date.valueOf(room.getStartDate()));
        lastDay.setTime(Date.valueOf(java.time.LocalDate.now()));
        long noDay = ((lastDay.getTime().getTime() - firstDay.getTime().getTime()) / (24 * 3600 * 1000));
        return (noDay+1)*room.getPrice();
    }
}
