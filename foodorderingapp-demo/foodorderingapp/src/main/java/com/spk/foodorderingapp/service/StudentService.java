package com.spk.foodorderingapp.service;

import org.springframework.stereotype.Service;
import com.spk.foodorderingapp.model.OrderRecord;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {

    // In-memory store for demo purposes: orderId -> OrderRecord
    private final Map<Integer, OrderRecord> orders = new ConcurrentHashMap<>();

    public String login() {
        return "Student logged in successfully";
    }

    // Place an order and generate a unique QR token for pickup verification
    public String placeOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            return "Order ID already exists: " + orderId;
        }

        String qrToken = UUID.randomUUID().toString();
        OrderRecord record = new OrderRecord(orderId, qrToken, "Placed", LocalDateTime.now());
        orders.put(orderId, record);

        // In a real app we'd generate a QR image; here we return the token string
        return "Order placed with ID: " + orderId + ", QR: " + qrToken;
    }

    public String viewOrders() {
        if (orders.isEmpty()) return "No orders.";

        StringBuilder sb = new StringBuilder();
        for (OrderRecord r : orders.values()) {
            sb.append(r.toDisplayString()).append("\n");
        }
        return sb.toString();
    }

    // Verify QR token and mark the order as collected if valid
    public String verifyAndCollect(String qrToken) {
        Optional<OrderRecord> opt = orders.values().stream()
                .filter(r -> r.getQrToken().equals(qrToken))
                .findFirst();

        if (opt.isEmpty()) {
            return "Invalid QR token.";
        }

        OrderRecord record = opt.get();
        if (record.isCollected()) {
            return "Order already collected: " + record.getOrderId();
        }

        record.setCollected(true);
        record.setStatus("Collected");
        record.setCollectedTime(LocalDateTime.now());

        return "Order " + record.getOrderId() + " verified and marked as collected.";
    }
}
