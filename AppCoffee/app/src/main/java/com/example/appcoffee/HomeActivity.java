package com.example.appcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appcoffee.adapter.CategoryAdapter;
import com.example.appcoffee.api.ApiService;
import com.example.appcoffee.model.Category;
import com.example.appcoffee.model.OrderDetail;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Category> categories;
    CategoryAdapter adapter;
    ListView lvCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvCategory = findViewById(R.id.lv_category);
        GetListCategory();
        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HomeActivity.this,ProductActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("category",categories.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void GetListCategory() {
        ApiService.apiService.GetCategory().enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                categories = response.body();
                adapter = new CategoryAdapter(HomeActivity.this,R.layout.item_category,categories);
                lvCategory.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "erorr !!!", Toast.LENGTH_SHORT).show();
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