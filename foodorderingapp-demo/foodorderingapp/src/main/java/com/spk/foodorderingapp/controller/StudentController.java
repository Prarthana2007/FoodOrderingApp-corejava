package com.spk.foodorderingapp.controller;

import com.spk.foodorderingapp.model.OrderRecord;
import com.spk.foodorderingapp.service.AppDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AppDataService dataService;

    @GetMapping("/login")
    public String login() {
        return dataService.loginStudent();
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam int orderId) {
        return dataService.placeOrder(orderId);
    }

    @GetMapping("/orders")
    public List<OrderRecord> viewOrders() {
        return dataService.getOrders();
    }

    @PostMapping("/pay")
    public String payOrder(@RequestParam int orderId) {
        return dataService.payOrder(orderId);
    }
}
