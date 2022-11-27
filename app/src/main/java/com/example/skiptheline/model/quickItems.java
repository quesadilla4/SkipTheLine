package com.example.skiptheline.model;

public class quickItems {

    String name;
    Integer imageUrl;


    public quickItems(String name, Integer imageUrl, String restaurantName, String price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.restaurantName = restaurantName;
        this.price = price;
    }

    String restaurantName;
    String price;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
