package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class user_Mota extends AppCompatActivity {
    TextView mota_name, mota_phanLoai, mota_price;
    ImageView mota_img;
    ImageButton btn_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_mota);

        mota_name = findViewById(R.id.mota_name);
        mota_phanLoai = findViewById(R.id.mota_phanLoai);
        mota_price = findViewById(R.id.mota_price);
        mota_img = findViewById(R.id.mota_img);
        btn_back = findViewById(R.id.btn_back);

        if (btn_back != null) {
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        Intent intent = getIntent();
        if (intent != null) {
            String ten = intent.getStringExtra("tenGiay");
            String loai = intent.getStringExtra("loaiGiay");
            long gia = intent.getLongExtra("giaGiay", 0);
            String imgUriStr = intent.getStringExtra("imgGiay");

            if (ten != null) mota_name.setText(ten);
            if (loai != null) mota_phanLoai.setText(loai);
            if (gia > 0) mota_price.setText(String.format("%,dđ", gia));
            if (imgUriStr != null && mota_img != null) {
                mota_img.setImageURI(Uri.parse(imgUriStr));
            }
        }
    }
}
