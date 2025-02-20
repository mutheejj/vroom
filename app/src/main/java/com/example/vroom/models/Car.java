package com.example.vroom.models;

public class Car {
    private String id;
    private String name;
    private String brand;
    private String description;
    private int year;
    private double price;
    private String imageUrl;
    private boolean available;

    // Empty constructor needed for Firestore
    public Car() {}

    public Car(String id, String name, String description, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.brand = "Audi";
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public String getDescription() { return description; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }
    public boolean isAvailable() { return available; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setDescription(String description) { this.description = description; }
    public void setYear(int year) { this.year = year; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setAvailable(boolean available) { this.available = available; }
} 