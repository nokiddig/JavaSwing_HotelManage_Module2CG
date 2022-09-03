package model.entity;

public class Room {
    private String roomID = "0";
    private int large = 0, bed = 0;
    private int price = 0;
    private String startDate = "2022-01-01";
    private String status = "Available"; //change about name user

    public Room (String id, int large, int nBed, int price) {
        this.roomID = id;
        this.large = large;
        this.bed = nBed;
        this.price = price;
    }
    public void setBed(int bed) {
        this.bed = bed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public int getBed() {
        return bed;
    }

    public int getLarge() {
        return large;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }
}
