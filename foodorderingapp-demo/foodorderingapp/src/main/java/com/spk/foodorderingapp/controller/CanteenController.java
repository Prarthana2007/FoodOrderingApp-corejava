package com.spk.foodorderingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spk.foodorderingapp.service.StudentService;

@RestController
@RequestMapping("/canteen")
public class CanteenController {

    @Autowired
    private StudentService studentService;

    // Endpoint for staff to scan QR token and mark order collected
    @PostMapping("/collect")
    public String collectByQr(@RequestParam String qr) {
        return studentService.verifyAndCollect(qr);
    }
}
