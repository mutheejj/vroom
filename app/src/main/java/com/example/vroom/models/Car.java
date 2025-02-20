package com.example.vroom.models;

public class Car {
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageResourceName;

    // Empty constructor needed for Firestore
    public Car() {}

    public Car(String id, String name, String description, double price, String imageResourceName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceName = imageResourceName;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getImageResourceName() { return imageResourceName; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setImageResourceName(String imageResourceName) { this.imageResourceName = imageResourceName; }
} 