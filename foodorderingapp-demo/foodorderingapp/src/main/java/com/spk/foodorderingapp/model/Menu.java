package com.spk;

import java.util.*;

public class Menu {

    private List<FoodItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }

    public void displayItems() {
        for (FoodItem item : items) {
            System.out.println(item.getItemId() + " - " +
                    item.getName() + " - ₹" + item.getPrice());
        }
    }

    public List<FoodItem> getItems() {
        return items;
    }
}