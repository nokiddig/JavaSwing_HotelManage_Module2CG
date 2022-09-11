package view.admin;

import model.input.ReadWriteRoom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RoomManagePanel extends JPanel {
    private ArrayList<ARoomPanel> listARoomPanels = new ArrayList<>();
    private ReadWriteRoom readWriteRoom;
    private int numOfRooms = 0;
    private int row = 0;
    private final int col = 4;

    public RoomManagePanel() {
        this.init();
    }

    public void init() {
        readWriteRoom = ReadWriteRoom.getInstance();
        this.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        this.numOfRooms = readWriteRoom.getListRooms().size();
        row = numOfRooms / col + (numOfRooms % col == 0 ? 0 : 1);
        this.setLayout(new GridLayout(this.row, this.col, 10, 10));

        for (int i=0; i<numOfRooms; i++) {
            listARoomPanels.add(new ARoomPanel(readWriteRoom.getListRooms().get(i)));
            this.add(listARoomPanels.get(i));
        }
    }
}