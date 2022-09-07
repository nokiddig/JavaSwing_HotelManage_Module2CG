package controller.adminListener;

import model.input.ReadWriteRoom;
import model.entity.Room;
import model.input.Validate;
import view.adminManager.JPUpdateRoom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomListener implements ActionListener {
    private JPUpdateRoom jpUpdateRoom;
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();
    private Validate validate = new Validate();

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

        startCRUD:
        if (validate.checkRoom(ID, large, nBed, price) || str.equals("Delete")) {
            int notFound = -1;
            if (str.equals("Edit")){
                Room room = new Room(ID, Integer.parseInt(large), Integer.parseInt(nBed), Integer.parseInt(price));
                if (readWriteRoom.searchRoom(ID) == notFound) {
                    JOptionPane.showMessageDialog(null, "ID not found!");
                    break startCRUD;
                }
                else {
                    readWriteRoom.editRoom(room);
                }
            }

            if (str.equals("Delete")) {
                if (readWriteRoom.searchRoom(ID) == notFound) {
                    JOptionPane.showMessageDialog(null, "ID not found!");
                    break startCRUD;
                }
                else {
                    readWriteRoom.deleteRoom(ID);
                }
            }

            if (str.equals("Add")) {
                Room room = new Room(ID, Integer.parseInt(large), Integer.parseInt(nBed), Integer.parseInt(price));
                if (readWriteRoom.searchRoom(ID) != notFound) {
                    JOptionPane.showMessageDialog(null, "ID existed!");
                    break startCRUD;
                }
                else {
                    readWriteRoom.addRoom(room);
                }
            }
            jpUpdateRoom.getHM().refreshRoom();
            JOptionPane.showMessageDialog(null, "Done!!");
        }
        else {
            validate.showHandleRoom();
        }
    }
}
