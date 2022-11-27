package com.example.skiptheline.util;

public class OrderClass {

    private int id;
    private int dishId;
    private int customerId;
    private int status;
    private String placingDate;
    private String placingTime;
    private String acceptanceDate;
    private String acceptanceTime;
    private String cancellationDate;
    private String cancellationTime;
    private String readyDate;
    private String readyTime;
    private String completedDate;
    private String completedTime;


    public OrderClass(int id, int dishId, int customerId, int status, String placingDate, String placingTime, String acceptanceDate, String acceptanceTime, String cancellationDate, String cancellationTime, String readyDate, String readyTime, String completedDate, String completedTime) {
        this.id = id;
        this.dishId = dishId;
        this.customerId = customerId;
        this.placingDate = placingDate;
        this.placingTime = placingTime;
        this.acceptanceDate = acceptanceDate;
        this.acceptanceTime = acceptanceTime;
        this.cancellationDate = cancellationDate;
        this.cancellationTime = cancellationTime;
        this.readyDate = readyDate;
        this.readyTime = readyTime;
        this.completedDate = completedDate;
        this.completedTime = completedTime;
        this.status = status;
    }

    public OrderClass() {
    }

    @Override
    public String toString() {
        return "OrderClass{" +
                "id=" + id +
                ", dishId=" + dishId +
                ", customerId=" + customerId +
                ", placingDate='" + placingDate + '\'' +
                ", placingTime='" + placingTime + '\'' +
                ", acceptanceDate='" + acceptanceDate + '\'' +
                ", acceptanceTime='" + acceptanceTime + '\'' +
                ", cancellationDate='" + cancellationDate + '\'' +
                ", cancellationTime='" + cancellationTime + '\'' +
                ", readyDate='" + readyDate + '\'' +
                ", readyTime='" + readyTime + '\'' +
                ", completedDate='" + completedDate + '\'' +
                ", completedTime='" + completedTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPlacingDate() {
        return placingDate;
    }

    public void setPlacingDate(String placingDate) {
        this.placingDate = placingDate;
    }

    public String getPlacingTime() {
        return placingTime;
    }

    public void setPlacingTime(String placingTime) {
        this.placingTime = placingTime;
    }

    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(String acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

    public String getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getCancellationTime() {
        return cancellationTime;
    }

    public void setCancellationTime(String cancellationTime) {
        this.cancellationTime = cancellationTime;
    }

    public String getReadyDate() {
        return readyDate;
    }

    public void setReadyDate(String readyDate) {
        this.readyDate = readyDate;
    }

    public String getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(String readyTime) {
        this.readyTime = readyTime;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
