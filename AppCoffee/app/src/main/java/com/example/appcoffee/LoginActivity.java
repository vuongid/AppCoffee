package com.example.appcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appcoffee.api.ApiService;
import com.example.appcoffee.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserLogin, edtPasswordl;
    private Button btnLogin, btnCreateUser;
    private TextView tvCreateUser;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtUserLogin = findViewById(R.id.edt_user_login);
        edtPasswordl = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        tvCreateUser = findViewById(R.id.tv_create_user);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickLogin();
            }
        });

        tvCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickCreateUser();
            }
        });
    }

    private void ClickCreateUser() {
        Intent intent = new Intent(this,CreateUserActivity.class);
        startActivity(intent);
    }

    private void ClickLogin() {
        String userName = edtUserLogin.getText().toString().trim();
        String password = edtPasswordl.getText().toString().trim();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Nhập thông tin", Toast.LENGTH_SHORT).show();
        } else {
            ApiService.apiService.PostLoginUser(userName, password).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    user = response.body();
                    Toast.makeText(LoginActivity.this,"Xin chào " + user.getName(), Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Kiểm tra lại tên tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}