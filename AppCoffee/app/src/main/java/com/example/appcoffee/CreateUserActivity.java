package com.example.appcoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appcoffee.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity {
    private EditText edtUserLogin,edtPassword,edtConfirmPassword,edtName,edtAddress,edtPhone;
    private Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtUserLogin = findViewById(R.id.edt_user_login);
        edtPassword = findViewById(R.id.edt_password);
        edtConfirmPassword = findViewById(R.id.edt_confirm_password);
        edtName = findViewById(R.id.edt_name);
        edtAddress = findViewById(R.id.edt_address);
        edtPhone = findViewById(R.id.edt_phone);
        btnCreate = findViewById(R.id.btn_create);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickCreate();
            }
        });
    }

    private void ClickCreate() {
        String userLogin = edtUserLogin.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String confirmPassword = edtConfirmPassword.getText().toString().trim();
        String name = edtName.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();

        if (TextUtils.isEmpty(userLogin) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword) ||
        TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Nhập thông tin", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(confirmPassword)){
                ApiService.apiService.PostCreateUser(userLogin,password,name,address,phone).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.body().equals("SUCCESS")){
                            Toast.makeText(CreateUserActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(CreateUserActivity.this, "Trùng tên đăng nhập", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(CreateUserActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(this, "Xác nhận lại mật khẩu", Toast.LENGTH_SHORT).show();
            }
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
    }}