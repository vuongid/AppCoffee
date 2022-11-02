package com.example.appcoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.appcoffee.api.ApiService;
import com.example.appcoffee.model.OrderDetail;
import com.example.appcoffee.model.User;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderConfirmActivity extends AppCompatActivity {
    private EditText edtName,edtPhone,edtAddress;
    private TextView tvTotalPrice;
    private Button btnConfrim;
    private int totalQuantity,totalPrice;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirm);

        edtName = findViewById(R.id.edt_name);
        edtPhone = findViewById(R.id.edt_phone);
        edtAddress = findViewById(R.id.edt_address);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        btnConfrim = findViewById(R.id.btn_confirm);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        totalQuantity = bundle.getInt("total_quantity");
        totalPrice = bundle.getInt("total_price");
        user = LoginActivity.user;
        edtName.setText(user.getName());
        edtPhone.setText(user.getPhone());
        edtAddress.setText(user.getAddress());
        tvTotalPrice.setText("Tổng tiền: " + String.valueOf(totalPrice));

        btnConfrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickConfrim();
            }
        });
    }

    private void ClickConfrim() {
        String address = edtAddress.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateformat.format(calendar.getTime());
        if (TextUtils.isEmpty(address) || TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Nhập thông tin", Toast.LENGTH_SHORT).show();
        } else {
            ApiService.apiService.PostOrder(user.getUserId(),date,totalQuantity,totalPrice,address,phone).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String orderId = response.body();
                    for (OrderDetail orderDetail : ProductDetailActivity.orderDetails) {
                        ApiService.apiService.PostOrderDetail(
                                        Integer.parseInt(orderId),
                                        orderDetail.getProductId(),
                                        orderDetail.getProductName(),
                                        orderDetail.getProductImage(),
                                        orderDetail.getProductQuantity(),
                                        orderDetail.getProductPrice())
                                .enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        if (response.body().equals("SUCCESS")){
                                            ProductDetailActivity.orderDetails.clear();
                                            Toast.makeText(OrderConfirmActivity.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(OrderConfirmActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {
                                        Toast.makeText(OrderConfirmActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(OrderConfirmActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}