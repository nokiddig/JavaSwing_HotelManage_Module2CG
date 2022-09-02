package controller;

import fileReadWrite.ReadWriteRoom;
import model.entity.Account;
import model.entity.Room;
import view.adminManager.JPUpdateRoom;
import view.adminManager.RoomManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomListener implements ActionListener {
    private JPUpdateRoom jpUpdateRoom;
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();

    public UpdateRoomListener(JPUpdateRoom jpUpdateRoom) {
        this.jpUpdateRoom = jpUpdateRoom;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        String ID = jpUpdateRoom.getJtfID().getText().trim();
        String large = jpUpdateRoom.getJtfLarge().getText();
        String nBed = jpUpdateRoom.getJtfBed().getText().trim();
        String price = jpUpdateRoom.getJtfPrice().getText().trim();
        Room room = new Room(ID, Integer.parseInt(large), Integer.parseInt(nBed), Integer.parseInt(price));
        if (ID.equals("")) {
            return;
        }
        if (str.equals("Edit")){
            readWriteRoom.editRoom(room);
        }
        if (str.equals("Delete")) {
            readWriteRoom.deleteRoom(room.getRoomID());
        }
        if (str.equals("Add")) {
            readWriteRoom.addRoom(room);
        }
    }
}
