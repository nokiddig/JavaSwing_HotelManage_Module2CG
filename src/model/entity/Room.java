package model.entity;

public class Room {
    private final String roomID;
    private int large, bed, price;
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
