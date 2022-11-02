package com.example.appcoffee.model;

public class OrderDetail {
    private int orderId;
    private int productId;
    private String productName;
    private String productImage;
    private int productQuantity;
    private int productPrice;

    public OrderDetail(int productId, String productName, String productImage, int productQuantity, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
