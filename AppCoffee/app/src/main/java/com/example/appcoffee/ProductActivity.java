package com.example.appcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appcoffee.adapter.ProductAdapter;
import com.example.appcoffee.api.ApiService;
import com.example.appcoffee.model.Category;
import com.example.appcoffee.model.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    private ListView lvProduct;
    private ArrayList<Product> products;
    private ProductAdapter productAdapter;
    private Category category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvProduct = findViewById(R.id.lv_product);
        GetProduct();
        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ProductActivity.this, ProductDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",products.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        
    }

    private void GetProduct() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            category = (Category) bundle.getSerializable("category");
            setTitle(category.getName());
        }
        ApiService.apiService.GetProduct(category.getCategoryId()).enqueue(new Callback<ArrayList<Product>>() {
            @Override
            public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {
                products = response.body();
                productAdapter = new ProductAdapter(ProductActivity.this,R.layout.item_product,products);
                lvProduct.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Product>> call, Throwable t) {
                Toast.makeText(ProductActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
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