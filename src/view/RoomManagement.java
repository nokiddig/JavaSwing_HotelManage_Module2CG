package view;

import model.Room;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class RoomManagement extends JPanel {
    private ArrayList<Room> listRooms = new ArrayList<Room>();
    private ArrayList<JPRoom> listJPRooms = new ArrayList<JPRoom>();
    private int numOfRooms = 0;
    private int row = 0, col = 4;

    public RoomManagement() {
        this.init();
    }

    private void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.readListRooms();
        this.numOfRooms = listRooms.size();
        System.out.println(numOfRooms);
        row = numOfRooms / col + (numOfRooms % col == 0 ? 0 : 1);
        this.setLayout(new GridLayout(this.row, this.col, 10, 10));

        for (int i=0; i<numOfRooms; i++) {
            listJPRooms.add(new JPRoom(listRooms.get(i)));
            this.add(listJPRooms.get(i));
        }
    }

    private void readListRooms() {
        try {
            File f = new File("fileIO\\Room\\roomInfo.txt");
            BufferedReader bufferedReader = Files.newBufferedReader(f.toPath(),
                    StandardCharsets.UTF_8);
            do{
                String ID;
                int large, bed, price;
                String startDate;
                ID = bufferedReader.readLine();
                if (ID == null) {
                    break;
                }
                large = Integer.parseInt(bufferedReader.readLine());
                bed = Integer.parseInt(bufferedReader.readLine());
                price = Integer.parseInt(bufferedReader.readLine());
                startDate = bufferedReader.readLine();

                Room room = new Room(ID, large, bed, price);
                room.setStartDate(startDate);
                listRooms.add(room);
            }
            while (true);
        } catch (Exception e) {
            System.out.println("Read list room fail!");
            e.printStackTrace();
        }
    }
}