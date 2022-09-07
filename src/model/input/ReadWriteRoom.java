package model.input;

import model.entity.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class ReadWriteRoom {
    private ArrayList<Room> listRooms;
    private final String src = "fileIO\\roomInfo.txt";
    private BufferedReader bufferedReader;

    public ReadWriteRoom () {
        this.readListRooms();
    }

    public void readListRooms() {
        listRooms = new ArrayList<>();
        try {
            File f = new File(src);
            bufferedReader = Files.newBufferedReader(f.toPath(),
                    StandardCharsets.UTF_8);
            do{
                String[] str = bufferedReader.readLine().split("~");
                if (str.length>0) {
                    Room room = new Room(str[0], Integer.parseInt(str[1]),
                            Integer.parseInt(str[2]), Integer.parseInt(str[3]));
                    room.setStartDate(str[4]);
                    room.setStatus(str[5]);
                    listRooms.add(room);
                }
                else {
                    break;
                }
            }
            while (true);
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("\n");
        }
    }

    public void writeListRooms () {
        try{
            PrintWriter pw = new PrintWriter(src);
            for (Room room : listRooms) {
                pw.println(room.getRoomID() + "~" + room.getLarge() + "~" +
                        room.getBed() + "~" + room.getPrice() + "~" +
                        room.getStartDate() + "~" + room.getStatus());
            }
            pw.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void addRoom(Room r) {
        readListRooms();
        listRooms.add(r);
        writeListRooms();
    }

    public void deleteRoom(String ID) {
        readListRooms();
        for (int i=0; i< listRooms.size(); i++) {
            if (listRooms.get(i).getRoomID().equals(ID)) {
                listRooms.remove(i);
                break;
            }
        }
        writeListRooms();
    }

    public void editRoom(Room r) {
        readListRooms();
        for (Room listRoom : listRooms) {
            if (listRoom.getRoomID().equals(r.getRoomID())) {
                listRoom.setStartDate(r.getStartDate());
                listRoom.setBed(r.getBed());
                listRoom.setPrice(r.getPrice());
                listRoom.setLarge(r.getLarge());
                listRoom.setStatus(r.getStatus());
                break;
            }
        }
        writeListRooms();
    }

    public int searchRoom(String ID) {
        for (int i=0; i<listRooms.size(); i++) {
            if (listRooms.get(i).getRoomID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Room> getListRooms() {
        return listRooms;
    }
}
