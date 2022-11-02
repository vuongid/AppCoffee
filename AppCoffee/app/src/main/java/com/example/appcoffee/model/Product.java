package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {
    @SerializedName("idSP")
    private int productId;
    @SerializedName("idDM")
    private int categoryId;
    @SerializedName("ten")
    private String name;
    @SerializedName("donGia")
    private int price;
    @SerializedName("moTa")
    private String description;
    @SerializedName("hinhAnh")
    private String image;

    public Product(int productId, int categoryId, String name, int price, String description, String image) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
