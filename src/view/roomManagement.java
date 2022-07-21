package view;

import model.Room;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class roomManagement extends JPanel {
    private ArrayList<Room> listRooms = new ArrayList<Room>();
    private int numOfRooms = 0;
    private int row = 0, col = 4;

    public roomManagement() {
        this.init();
    }

    private void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.readListRooms();
        this.numOfRooms = listRooms.size();
        row = numOfRooms / col + (numOfRooms % col == 0 ? 0 : 1);
        this.setLayout(new GridLayout(this.row, this.col));
    }

    private void readListRooms() {
        try {
            File f = new File("fileIO\\Room\\roomInfo.txt");
            BufferedReader bufferedReader = Files.newBufferedReader(f.toPath(),
                    StandardCharsets.UTF_8);
            do{
                break;
            }
            while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
