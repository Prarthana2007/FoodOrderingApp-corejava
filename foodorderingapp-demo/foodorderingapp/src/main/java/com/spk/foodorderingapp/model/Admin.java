package com.spk;

public class Admin extends User {

    public Admin(int userId, String name, String phoneNumber, String email) {
        super(userId, name, phoneNumber, email, "Admin");
    }

    // Add item to menu
    public void addItem(Menu menu, FoodItem item) {
        menu.addItem(item);
        System.out.println(item.getName() + " added successfully.");
    }

    // Remove item
    public void removeItem(Menu menu, int itemId) {
        menu.removeItem(itemId);
        System.out.println("Item with ID " + itemId + " removed successfully.");
    }

    // Change availability
    public void changeAvailability(FoodItem item, boolean isAvailable) {
        item.setAvailable(isAvailable);
        System.out.println("Availability updated for " + item.getName());
    }

    // Update price
    public void updatePrice(FoodItem item, double newPrice) {
        item.setPrice(newPrice);
        System.out.println("Price updated for " + item.getName());
    }

    // View orders (basic placeholder)
    public void viewOrders() {
        System.out.println("Viewing all orders (integration pending).");
    }
}