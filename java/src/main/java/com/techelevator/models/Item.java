package com.techelevator.models;
import com.techelevator.application.ItemInterface;
import com.techelevator.application.VendingMachine;

public class Item extends VendingMachine implements ItemInterface {

    private String location;
    private String name;
    private double price;
    private String type;
    private int quantity;

    public Item (String location, String name, double price, String type) {

        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 6;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public String toString() {
        return location + ", " + name + ", " + "$" + price  + ", " + type + ", " + "QTY: " + quantity;
    }
}
