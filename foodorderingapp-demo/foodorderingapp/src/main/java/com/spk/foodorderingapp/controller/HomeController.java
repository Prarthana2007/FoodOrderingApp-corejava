package com.spk.foodorderingapp.controller;

import com.spk.foodorderingapp.model.CanteenInfo;
import com.spk.foodorderingapp.service.AppDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private AppDataService dataService;

    @GetMapping("/canteens")
    public List<CanteenInfo> getCanteens() {
        return dataService.getCanteens();
    }
}
