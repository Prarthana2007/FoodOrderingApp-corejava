package com.spk.foodorderingapp.controller;

import com.spk.FoodItem;
import com.spk.foodorderingapp.service.AppDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AppDataService dataService;

    @PostMapping("/add-item")
    public String addItem(
            @RequestParam int itemId,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam boolean available) {
        return dataService.addMenuItem(itemId, name, price, available);
    }

    @GetMapping("/menu")
    public List<FoodItem> viewMenu() {
        return dataService.getMenu();
    }
}
