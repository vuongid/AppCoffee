package com.example.appcoffee.model;

public class Order {
    private int orderId;
    private String oderDate;
    private int totalQuantity;
    private int totalPrice;
    private String address;
    private String phone;

    public Order(int orderId, String oderDate, int totalQuantity, int totalPrice, String address, String phone) {
        this.orderId = orderId;
        this.oderDate = oderDate;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phone = phone;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOderDate() {
        return oderDate;
    }

    public void setOderDate(String oderDate) {
        this.oderDate = oderDate;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
