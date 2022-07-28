package model.fileReadWrite;

import model.entity.Room;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadWriteRoom {
    private ArrayList<Room> listRooms = new ArrayList<Room>();
    private String src = "fileIO\\Room\\roomInfo.txt";
    private BufferedReader bufferedReader;

    public ReadWriteRoom () {
        this.readListRooms();
    }

    private void readListRooms() {
        try {
            File f = new File(src);
            bufferedReader = Files.newBufferedReader(f.toPath(),
                    StandardCharsets.UTF_8);
            do{
                String[] str = bufferedReader.readLine().split("~");
                Room room = new Room(str[0], Integer.parseInt(str[1]),
                        Integer.parseInt(str[2]), Integer.parseInt(str[3]));
                room.setStartDate(str[4]);
                listRooms.add(room);
            }
            while (true);
        } catch (Exception e) {
            System.out.println("Read list room fail!");
            //e.printStackTrace();
        }
    }

    public void WriteListRooms () {

    }

    public ArrayList<Room> getListRooms() {
        return listRooms;
    }
}
