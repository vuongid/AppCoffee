package com.example.appcoffee.api;

import com.example.appcoffee.model.Category;
import com.example.appcoffee.model.Order;
import com.example.appcoffee.model.Product;
import com.example.appcoffee.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
//    Gson gson1 = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
    Gson gson = new GsonBuilder().setLenient().create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.11/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("AppCoffee/getCategory.php")
    Call<ArrayList<Category>> GetCategory();

    @FormUrlEncoded
    @POST("AppCoffee/getProduct.php")
    Call<ArrayList<Product>> GetProduct(@Field("idDM") int caterogyId);

    @FormUrlEncoded
    @POST("AppCoffee/postOrder.php")
    Call<String> PostOrder(@Field("idKhachHang") int userId,
                           @Field("ngayBan") String date,
                           @Field("tongSoLuong") int totalQuatity,
                           @Field("tongTien") int totalPrice,
                           @Field("diaChi") String address,
                           @Field("soDienThoai") String phone);

    @FormUrlEncoded
    @POST("AppCoffee/postOrderDetail.php")
    Call<String>  PostOrderDetail(@Field("idHoaDon") int oderId,
                                  @Field("idSanPham") int productId,
                                  @Field("ten") String productName,
                                  @Field("hinhAnh") String image,
                                  @Field("soLuong") int quantity,
                                  @Field("donGia") int price);

    @FormUrlEncoded
    @POST("AppCoffee/postLoginUser.php")
    Call<User> PostLoginUser(@Field("tenDangNhap") String userLogin,
                               @Field("matKhau") String password);

    @FormUrlEncoded
    @POST("AppCoffee/postCreateUser.php")
    Call<String> PostCreateUser(@Field("tenDangNhap") String userLogin,
                              @Field("matKhau") String password,
                              @Field("hoTen") String name,
                              @Field("diaChi") String address,
                              @Field("soDienThoai") String phone);
}
