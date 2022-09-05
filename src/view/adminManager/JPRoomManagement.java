package view.adminManager;

import model.input.ReadWriteRoom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPRoomManagement extends JPanel {
    private ArrayList<JPRoom> listJPRooms = new ArrayList<>();
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();
    private int numOfRooms = 0;
    private int row = 0;
    private final int col = 4;

    public JPRoomManagement() {
        this.init();
    }

    public void init() {
        this.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        this.numOfRooms = readWriteRoom.getListRooms().size();
        row = numOfRooms / col + (numOfRooms % col == 0 ? 0 : 1);
        this.setLayout(new GridLayout(this.row, this.col, 10, 10));

        for (int i=0; i<numOfRooms; i++) {
            listJPRooms.add(new JPRoom(readWriteRoom.getListRooms().get(i)));
            this.add(listJPRooms.get(i));
        }
    }
}