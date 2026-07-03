package com.spk.foodorderingapp.model;

public class CanteenInfo {
    private String name;
    private String description;
    private String imageUrl;
    private String location;

    public CanteenInfo(String name, String description, String imageUrl, String location) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLocation() {
        return location;
    }
}
