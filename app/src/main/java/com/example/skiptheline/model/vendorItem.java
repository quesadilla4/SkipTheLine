package com.example.skiptheline.model;

public class vendorItem {

    String orderNumber;
    String orderItem1;
    String orderItem2;
    String orderItem3;
    String priceToPay;

    public vendorItem(String orderNumber, String orderItem1, String orderItem2, String orderItem3, String priceToPay) {
        this.orderNumber = orderNumber;
        this.orderItem1 = orderItem1;
        this.orderItem2 = orderItem2;
        this.orderItem3 = orderItem3;
        this.priceToPay = priceToPay;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderItem1() {
        return orderItem1;
    }

    public void setOrderItem1(String orderItem1) {
        this.orderItem1 = orderItem1;
    }

    public String getOrderItem2() {
        return orderItem2;
    }

    public void setOrderItem2(String orderItem2) {
        this.orderItem2 = orderItem2;
    }

    public String getOrderItem3() {
        return orderItem3;
    }

    public void setOrderItem3(String orderItem3) {
        this.orderItem3 = orderItem3;
    }

    public String getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(String priceToPay) {
        this.priceToPay = priceToPay;
    }
}
