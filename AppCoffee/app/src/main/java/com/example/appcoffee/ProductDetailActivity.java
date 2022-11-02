package com.example.appcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcoffee.model.OrderDetail;
import com.example.appcoffee.model.Product;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {

    private Product product;
    private ImageView imgProduct,imgIncrease,imgDecrease;
    private TextView tvPrice,tvDescription,tvAmount;
    private Button btnBuy;
    private int quantity = 1;
    public static ArrayList<OrderDetail> orderDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ShowProductDetail();

    }

    private void ShowProductDetail() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            product = (Product) bundle.getSerializable("product");
        }
        setTitle(product.getName());
        imgProduct =  findViewById(R.id.img_product_detail);
        imgIncrease = findViewById(R.id.img_increase);
        imgDecrease = findViewById(R.id.img_decrease);
        tvPrice = findViewById(R.id.tv_price_detail);
        tvDescription = findViewById(R.id.tv_description);
        tvAmount = findViewById(R.id.tv_amount);
        btnBuy = findViewById(R.id.btn_buy);

        Uri imgUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + product.getImage());
        imgProduct.setImageURI(imgUri);
        tvPrice.setText(String.valueOf(product.getPrice()));
        tvDescription.setText(product.getDescription());
        tvAmount.setText(String.valueOf(quantity));

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean productExist = false;
                if (orderDetails.isEmpty()){
                    orderDetails.add(new OrderDetail(product.getProductId(),product.getName(),product.getImage(),quantity,product.getPrice()));
                } else{
                    for (int i = 0; i < orderDetails.size(); i++){
                        if (orderDetails.get(i).getProductId() == product.getProductId()){
                            orderDetails.get(i).setProductQuantity(orderDetails.get(i).getProductQuantity()+quantity);
                            productExist = true;
                        }
                    }
                    if (!productExist){
                        orderDetails.add(new OrderDetail(product.getProductId(),product.getName(),product.getImage(),quantity,product.getPrice()));
                    }
                }
                Toast.makeText(ProductDetailActivity.this, "Thêm "+tvAmount.getText()+ " sản phẩm" , Toast.LENGTH_SHORT).show();
                tvAmount.setText("1");
                quantity = 1;
            }
        });

        imgIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickIncrease();
            }
        });
        imgDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickDecrease();
            }
        });
    }

    private void ClickDecrease() {
        quantity--;
        if(quantity < 1 ){
            quantity = 1;
        }
        tvAmount.setText(String.valueOf(quantity));
    }

    private void ClickIncrease() {
        quantity++;
        tvAmount.setText(String.valueOf(quantity));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_cart,menu);
        return super.onCreateOptionsMenu(menu);
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