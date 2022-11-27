package com.example.skiptheline.util;

public class DishClass {

    private int id;
    private String name;
    private String vendorName;
    private float price;
    private String category;
    private boolean isActive;
    private String dateAdded;


    @Override
    public String toString() {
        return "DishClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", isActive=" + isActive +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
    }

    public DishClass(int id, String name, String vendorName, float price, String category, boolean isActive, String dateAdded) {
        this.id = id;
        this.name = name;
        this.vendorName = vendorName;
        this.price = price;
        this.category = category;
        this.isActive = isActive;
        this.dateAdded = dateAdded;
    }

    public DishClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
