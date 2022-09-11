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
    private final String SOURCE = "fileIO\\roomInfo.txt";
    private BufferedReader bufferedReader;
    private static ReadWriteRoom instance = null;

    private ReadWriteRoom() {
        listRooms = new ArrayList<>();
        this.readListRooms();
    }

    public static ReadWriteRoom getInstance() {
        if (instance == null) {
            instance = new ReadWriteRoom();
        }
        return instance;
    }

    public void readListRooms() {
        try {
            File f = new File(SOURCE);
            bufferedReader = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
            do{
                String[] str = bufferedReader.readLine().split("~");
                if (str.length>0) {
                    Room room = new Room(str[0], Integer.parseInt(str[1]),
                            Integer.parseInt(str[2]), Integer.parseInt(str[3]));
                    room.setStartDate(str[4]);
                    room.setStatus(str[5]);
                    room.setServicePay(Integer.parseInt(str[6]));
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
            PrintWriter pw = new PrintWriter(SOURCE);
            for (Room room : listRooms) {
                pw.println(room.getRoomID() + "~" + room.getLarge() + "~" +
                        room.getBed() + "~" + room.getPrice() + "~" +
                        room.getStartDate() + "~" + room.getStatus() + "~" +
                        room.getServicePay());
            }
            pw.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void addRoom(Room r) {
        listRooms.add(r);
    }

    public void deleteRoom(String ID) {
        for (int i=0; i< listRooms.size(); i++) {
            if (listRooms.get(i).getRoomID().equals(ID)) {
                listRooms.remove(i);
                break;
            }
        }
    }

    public void editRoom(Room r) {
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
