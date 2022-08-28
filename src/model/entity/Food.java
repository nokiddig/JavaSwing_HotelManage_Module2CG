package model.entity;

public class Food {
    private int price = 0;
    private String name = "";
    private String describe = "";

    public Food() {
    }

    public Food(int price, String name, String describe) {
        this.price = price;
        this.name = name;
        this.describe = describe;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
