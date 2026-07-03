package com.spk.foodorderingapp.service;

import com.spk.FoodItem;
import com.spk.foodorderingapp.model.CanteenInfo;
import com.spk.foodorderingapp.model.OrderRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AppDataService {

    private final List<FoodItem> menu = Collections.synchronizedList(new ArrayList<>());
    private final List<CanteenInfo> canteens = Collections.synchronizedList(new ArrayList<>());
    private final Map<Integer, OrderRecord> orders = new ConcurrentHashMap<>();

    public AppDataService() {
        menu.add(new FoodItem(101, "Cheese Dosa", 55.0, true));
        menu.add(new FoodItem(102, "Paneer Wrap", 75.0, true));
        menu.add(new FoodItem(103, "Veg Biryani", 90.0, true));
        menu.add(new FoodItem(104, "Cold Coffee", 45.0, true));
        menu.add(new FoodItem(105, "Samosa", 20.0, false));

        canteens.add(new CanteenInfo("Campus Central", "Open 8am - 6pm", "https://images.unsplash.com/photo-1513104890138-7c749659a591?auto=format&fit=crop&w=800&q=80", "Main Block"));
        canteens.add(new CanteenInfo("Library Cafe", "Quiet zone with fresh snacks", "https://images.unsplash.com/photo-1529042410759-befb1204b468?auto=format&fit=crop&w=800&q=80", "Library"));
        canteens.add(new CanteenInfo("Sports Canteen", "Quick bites after practice", "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=800&q=80", "Sports Complex"));
    }

    public List<FoodItem> getMenu() {
        return new ArrayList<>(menu);
    }

    public List<CanteenInfo> getCanteens() {
        return new ArrayList<>(canteens);
    }

    public String addMenuItem(int itemId, String name, double price, boolean available) {
        Optional<FoodItem> existing = menu.stream().filter(item -> item.getItemId() == itemId).findFirst();
        if (existing.isPresent()) {
            return "Item already exists with ID: " + itemId;
        }
        menu.add(new FoodItem(itemId, name, price, available));
        return "Menu item added: " + name;
    }

    public String loginStudent() {
        return "Welcome to Campus Bites!";
    }

    public String placeOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            return "Order ID already exists: " + orderId;
        }
        String qrToken = UUID.randomUUID().toString();
        OrderRecord record = new OrderRecord(orderId, qrToken, "Placed", LocalDateTime.now());
        orders.put(orderId, record);
        return "Order placed with ID: " + orderId + ". Use QR token for pickup: " + qrToken;
    }

    public List<OrderRecord> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public String payOrder(int orderId) {
        OrderRecord record = orders.get(orderId);
        if (record == null) {
            return "Order not found: " + orderId;
        }
        if (record.isCollected()) {
            return "Order already collected.";
        }
        record.setStatus("Paid");
        return "Payment received for order " + orderId + ".";
    }

    public String verifyAndCollect(String qrToken) {
        Optional<OrderRecord> optional = orders.values().stream()
                .filter(record -> record.getQrToken().equals(qrToken))
                .findFirst();
        if (optional.isEmpty()) {
            return "Invalid QR token.";
        }
        OrderRecord record = optional.get();
        if (record.isCollected()) {
            return "Order already collected: " + record.getOrderId();
        }
        record.setCollected(true);
        record.setStatus("Collected");
        record.setCollectedTime(LocalDateTime.now());
        return "Order " + record.getOrderId() + " verified and collected.";
    }
}
