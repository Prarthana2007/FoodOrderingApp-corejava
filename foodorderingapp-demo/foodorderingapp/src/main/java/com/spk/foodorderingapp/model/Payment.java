package com.spk;

public class Payment {

    private int paymentId;
    private double amount;
    private String status;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = "Pending";
    }

    public void makePayment() {
        status = "Completed";
        System.out.println("Payment of ₹" + amount + " successful");
    }

    public void verifyPayment() {
        if (status.equals("Completed")) {
            System.out.println("Payment verified");
        } else {
            System.out.println("Payment not completed");
        }
    }
}