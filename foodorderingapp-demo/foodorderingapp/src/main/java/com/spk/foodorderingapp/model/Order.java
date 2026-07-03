package com.spk;

import java.time.LocalDateTime;
import java.util.*;

public class Order {

    private int orderId;
    private List<OrderItem> items;
    private double totalAmount;
    private String status;
    private LocalDateTime orderTime;

    public Order(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = "Placed";
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalAmount += item.getTotalPrice();
    }

    public void displayOrder() {
    System.out.println("Order ID: " + orderId);
    System.out.println("Status: " + status);

    for (OrderItem item : items) {
        System.out.println(
            item.getFoodItem().getName() +
            " x " + item.getQuantity() +
            " = ₹" + item.getTotalPrice()
        );
    }

    System.out.println("Total: ₹" + totalAmount);
    }
    public void cancelOrder() {
        status = "Cancelled";
        System.out.println("Order cancelled.");
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}