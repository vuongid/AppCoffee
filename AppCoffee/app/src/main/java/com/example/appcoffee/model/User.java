package com.example.appcoffee.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id_khachhang")
    private int userId;
    @SerializedName("tendangnhap")
    private String userLogin;
    @SerializedName("matkhau")
    private String passowrd;
    @SerializedName("hoten")
    private String name;
    @SerializedName("diachi")
    private String address;
    @SerializedName("sodienthoai")
    private String phone;

    public User(int userId, String userLogin, String passowrd, String name, String address, String phone) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.passowrd = passowrd;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
