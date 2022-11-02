package com.example.appcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcoffee.adapter.OrderDetailAdapter;
import com.example.appcoffee.api.ApiService;
import com.example.appcoffee.model.Order;
import com.example.appcoffee.model.OrderDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    private ArrayList<OrderDetail> orderDetailArrayList;
    private OrderDetailAdapter orderDetailAdapter;
    private ListView lvOrder;
    private TextView tvTotalQuantity,tvTotalPrice;
    private Button btnBuy;
    private boolean active;

    @Override
    protected void onStop() {
        super.onStop();
        active = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        active = true;
        LayoutTotal();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Giỏ Hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        orderDetailArrayList = new ArrayList<>();
        orderDetailAdapter = new OrderDetailAdapter(OrderActivity.this,R.layout.item_order,ProductDetailActivity.orderDetails);
        lvOrder = findViewById(R.id.lv_order);
        lvOrder.setAdapter(orderDetailAdapter);
        tvTotalQuantity = findViewById(R.id.tv_total_quantity);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        btnBuy = findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickBuy();
            }
        });
    }

    private void ClickBuy() {
        if (LoginActivity.user == null){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, OrderConfirmActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("total_quantity",Integer.parseInt((tvTotalQuantity.getText().toString())));
            bundle.putInt("total_price",Integer.parseInt(tvTotalPrice.getText().toString()));
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private void LayoutTotal() {
        Runnable runnable;
        Handler handler;
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int totalQuantity = 0;
                int totalPrice = 0;
                for (OrderDetail orderDetail : ProductDetailActivity.orderDetails) {
                    totalQuantity += orderDetail.getProductQuantity();
                    totalPrice += orderDetail.getProductPrice()*orderDetail.getProductQuantity();
                }
                tvTotalPrice.setText(String.valueOf(totalPrice));
                tvTotalQuantity.setText(String.valueOf(totalQuantity));
                handler.postDelayed(this, 100);
                if (active == false){
                    handler.removeCallbacks(this);
                }
                if (ProductDetailActivity.orderDetails.size() < 1){
                    finish();
                }
            }
        };
        handler.postDelayed(runnable, 100);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.add_cart:
                if (ProductDetailActivity.orderDetails.size() > 0){
                    Intent intent = new Intent(this,OrderActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Giỏ hàng không có sản phẩm", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.login:
                if (LoginActivity.user == null){
                    Intent intentLogin = new Intent(this,LoginActivity.class);
                    startActivity(intentLogin);
                } else {
                    Intent intentUserDetail = new Intent(this,UserDetailActivity.class);
                    startActivity(intentUserDetail);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}