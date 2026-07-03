package com.spk;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Canteen {
    private int canteenId;
    private String canteenName;
    private String location;    
    private Menu menu;
    private LocalTime openingTime;
    private LocalTime closingTime;

    public Canteen(int canteenId, String canteenName, String location,
               LocalTime openingTime, LocalTime closingTime) {
        this.canteenId = canteenId;
        this.canteenName = canteenName;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.menu = new Menu();
    }
    public void displayMenu(){

    }
    public Menu getMenu(){
        return menu;
    }
    public boolean isOpen(){
        LocalTime currentTime=LocalTime.now();
        return currentTime.isAfter(openingTime)&& currentTime.isBefore(closingTime);
    }
    }