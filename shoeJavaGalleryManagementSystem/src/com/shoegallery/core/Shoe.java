package com.shoegallery.core;

public class Shoe implements Comparable<Shoe> {
    private static int idCounter = 100;

    private int shoeId;
    private String name;
    private String brand;
    private int ratings;
    private double price;
    private boolean availableInGallery;
    private ShoeType shoeType;

    public Shoe(String name, String brand, int ratings, double price, boolean availableInGallery, ShoeType shoeType) {
        this.shoeId = ++idCounter;
        this.name = name;
        this.brand = brand;
        this.ratings = ratings;
        this.price = price;
        this.availableInGallery = availableInGallery;
        this.shoeType = shoeType;
    }

    // --- Getters ---
    public int getShoeId() { return shoeId; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public boolean isAvailableInGallery() { return availableInGallery; }

    // --- Setters ---
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Shoe [ID=" + shoeId + ", Name=" + name + ", Brand=" + brand + ", Type=" + shoeType +
               ", Rating=" + ratings + "/10, Price=₹" + price + ", Available=" + availableInGallery + "]";
    }

    /**
     * CORRECT IMPLEMENTATION: Compares two shoes based on their price for sorting in descending order.
     * This is the "natural sorting order" for Shoe objects as per the exam requirement.
     */
    @Override
    public int compareTo(Shoe other) {
        // Use Double.compare for safe comparison of double values
        // To sort descending, compare other.price to this.price
        return Double.compare(other.price, this.price);
    }
}

