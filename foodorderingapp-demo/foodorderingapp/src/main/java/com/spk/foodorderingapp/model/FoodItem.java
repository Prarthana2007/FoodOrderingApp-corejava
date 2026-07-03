package com.spk;

public class FoodItem {

    private int itemId;
    private String name;
    private double price;
    private boolean available;

    public FoodItem(int itemId, String name, double price, boolean available) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}