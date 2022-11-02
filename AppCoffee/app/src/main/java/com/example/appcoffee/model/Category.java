package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {
    @SerializedName("idDM")
    private int categoryId;
    @SerializedName("ten")
    private String name;
    @SerializedName("hinhAnh")
    private String image;

    public Category(int categoryId, String name, String image) {
        this.categoryId = categoryId;
        this.name = name;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
