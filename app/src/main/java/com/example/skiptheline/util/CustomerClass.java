package com.example.skiptheline.util;

public class CustomerClass {

    private int id;
    private String name;
    private String email;
    private String password;
    private String dateAdded;
    private boolean isActive;
    private boolean isVendor;

    @Override
    public String toString() {
        return "CustomerClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", isActive=" + isActive +
                ", isVendor=" + isVendor +
                '}';
    }

    public CustomerClass(int id, String name, String email, String password, String dateAdded, boolean isActive, boolean isVendor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateAdded = dateAdded;
        this.isActive = isActive;
        this.isVendor = isVendor;
    }

    public CustomerClass() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVendor() {
        return isVendor;
    }

    public void setVendor(boolean vendor) {
        isVendor = vendor;
    }
}
