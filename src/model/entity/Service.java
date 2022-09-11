package model.entity;
public class Service {
    private String name = "";
    private int price;

    public Service(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service: " + name +
                ", price: " + price + "\n";
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
