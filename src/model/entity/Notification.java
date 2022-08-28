package model.entity;

public class Notification {
    public String typeOfNo = "";
    public String dataOfNo = "";

    public Notification() {
    }

    public Notification(String type, String data) {
        this.typeOfNo = type;
        this.dataOfNo = data;
    }

    public String getDataOfNo() {
        return dataOfNo;
    }

    public String getTypeOfNo() {
        return typeOfNo;
    }

    public void setDataOfNo(String dataOfNo) {
        this.dataOfNo = dataOfNo;
    }

    public void setTypeOfNo(String typeOfNo) {
        this.typeOfNo = typeOfNo;
    }
}
