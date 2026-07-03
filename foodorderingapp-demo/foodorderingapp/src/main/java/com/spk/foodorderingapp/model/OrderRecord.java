package com.spk.foodorderingapp.model;

import java.time.LocalDateTime;

public class OrderRecord {
    private int orderId;
    private String qrToken;
    private String status;
    private LocalDateTime orderTime;
    private boolean collected;
    private LocalDateTime collectedTime;

    public OrderRecord(int orderId, String qrToken, String status, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.qrToken = qrToken;
        this.status = status;
        this.orderTime = orderTime;
        this.collected = false;
    }

    public int getOrderId() { return orderId; }
    public String getQrToken() { return qrToken; }
    public String getStatus() { return status; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public boolean isCollected() { return collected; }
    public LocalDateTime getCollectedTime() { return collectedTime; }

    public void setStatus(String status) { this.status = status; }
    public void setCollected(boolean collected) { this.collected = collected; }
    public void setCollectedTime(LocalDateTime t) { this.collectedTime = t; }

    public String toDisplayString() {
        return "OrderId:" + orderId + " status:" + status + " qr:" + qrToken + " collected:" + collected;
    }
}
