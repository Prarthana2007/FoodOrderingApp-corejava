package com.spk;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private List<OrderItem> cart;
    private List<Order> orderHistory;

    public Student(int userId, String name, String phoneNumber, String email) {
        super(userId, name, phoneNumber, email, "Student");
        cart = new ArrayList<>();
        orderHistory = new ArrayList<>();
    }
    public void viewMenu(Menu menu) {
        menu.displayItems();
    }
    public void addToCart(FoodItem item) {
        if (item.isAvailable()) {
            OrderItem orderItem = new OrderItem(item, 1);
            cart.add(orderItem);
            System.out.println(item.getName() + " added to cart.");
        } else {
            System.out.println("Sorry, " + item.getName() + " is unavailable.");
        }
    }

    public Order placeOrder(int orderId) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty! Cannot place order.");
            return null;
        }

        Order order = new Order(orderId);

        for (OrderItem item : cart) {
            order.addItem(item);
        }

        System.out.println("Order placed successfully!");
        order.displayOrder();

        orderHistory.add(order);
        cart.clear();

        return order;
    }

    public void viewOrderHistory() {

        if (orderHistory.isEmpty()) {
            System.out.println("No previous orders.");
            return;
        }

        for (Order order : orderHistory) {
            order.displayOrder();
            System.out.println("------------------");
        }
    }
    public void cancelOrder() {
        cart.clear();
        System.out.println("Current cart order cancelled.");
    }
    public void login() {
        System.out.println(getName() + " logged in");
    }

    public void logout() {
        System.out.println(getName() + " logged out");
    }
}