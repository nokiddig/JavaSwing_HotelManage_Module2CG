package controller.admin;

import model.input.ReadWriteRoom;
import model.entity.Room;
import model.input.Validate;
import view.admin.UpdateRoomPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRoomListener implements ActionListener {
    private UpdateRoomPanel updateRoomPanel;
    private ReadWriteRoom readWriteRoom = new ReadWriteRoom();
    private Validate validate = new Validate();

    public UpdateRoomListener(UpdateRoomPanel updateRoomPanel) {
        this.updateRoomPanel = updateRoomPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        String ID = updateRoomPanel.getiDTextField().getText().trim();
        String large = updateRoomPanel.getLargeTextField().getText();
        String nBed = updateRoomPanel.getBedTextField().getText().trim();
        String price = updateRoomPanel.getPriceTextField().getText().trim();

        startCRUD:
        if (validate.checkRoom(ID, large, nBed, price) || str.equals("Delete")) {
            int notFound = -1;
            readWriteRoom.readListRooms();
            if (str.equals("Edit")){
                Room room = new Room(ID, Integer.parseInt(large), Integer.parseInt(nBed), Integer.parseInt(price));

                int index = readWriteRoom.searchRoom(ID);
                if (index == notFound) {
                    JOptionPane.showMessageDialog(null, "ID not found!");
                    break startCRUD;
                }
                else {
                    if(!readWriteRoom.getListRooms().get(index).getStatus().equals("Available")){
                        JOptionPane.showMessageDialog(null, "Room being using!");
                        break startCRUD;
                    }else {
                        readWriteRoom.editRoom(room);
                    }
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
            updateRoomPanel.getHM().refreshRoom();
            JOptionPane.showMessageDialog(null, "Done!!");
        }
        else {
            validate.showHandleRoom();
        }
    }
}
