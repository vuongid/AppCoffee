package com.example.appcoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appcoffee.model.OrderDetail;
import com.example.appcoffee.model.User;

public class UserDetailActivity extends AppCompatActivity {
    private EditText edtName,edtAddress,edtPhone;
    private Button btnLogout;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        edtName = findViewById(R.id.edt_name);
        edtAddress = findViewById(R.id.edt_address);
        edtPhone = findViewById(R.id.edt_phone);
        btnLogout = findViewById(R.id.btn_logout);
        user = LoginActivity.user ;

        edtName.setText(user.getName());
        edtAddress.setText(user.getAddress());
        edtPhone.setText(user.getPhone());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = null;
                Toast.makeText(UserDetailActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}