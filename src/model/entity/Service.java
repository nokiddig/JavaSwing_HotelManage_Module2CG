package model.entity;
public class Service {
    private String name = "";
    private int price;
    public Service() {
    }

    public Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
