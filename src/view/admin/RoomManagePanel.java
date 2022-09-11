package view.admin;

import model.input.ReadWriteRoom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RoomManagePanel extends JPanel {
    private ArrayList<ARoomPanel> listARoomPanels;
    private ReadWriteRoom readWriteRoom;
    private int numOfRooms;
    private int row;
    private final int COLUMN = 4;

    public RoomManagePanel() {
        this.setupView();
        this.addRoomJPanel();
    }

    private void setupView() {
        listARoomPanels = new ArrayList<>();
        readWriteRoom = ReadWriteRoom.getInstance();
        this.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        this.numOfRooms = readWriteRoom.getListRooms().size();
        row = numOfRooms / COLUMN + (numOfRooms % COLUMN == 0 ? 0 : 1);
        this.setLayout(new GridLayout(this.row, this.COLUMN, 10, 10));
    }

    private void addRoomJPanel() {
        for (int i=0; i<numOfRooms; i++) {
            listARoomPanels.add(new ARoomPanel(readWriteRoom.getListRooms().get(i)));
            this.add(listARoomPanels.get(i));
        }
    }
}