package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.gioHang.adaptergiohang;
import com.example.myapplication.gioHang.sanpham;

import java.util.ArrayList;

public class user_GioHang extends AppCompatActivity {
    ListView lvGioHang;
    ArrayList<sanpham> dsGioHang;
    adaptergiohang adapter;
    TextView vetrangchu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        vetrangchu = findViewById(R.id.vetrangchu);
        if (vetrangchu != null) {
            vetrangchu.setOnClickListener(v -> finish());
        }

        lvGioHang = findViewById(R.id.lvGioHang);
        dsGioHang = new ArrayList<>();

        // Thêm dữ liệu sản phẩm mẫu vào danh sách giỏ hàng
        dsGioHang.add(new sanpham("Giày cao gót", 120000, 1, R.drawable.giay1, 37));
        dsGioHang.add(new sanpham("Giày nữ cao cấp mới đế mềm Warrior", 500000, 1, R.drawable.giay1, 36));
        dsGioHang.add(new sanpham("Giày bầu đế mềm mùa hè thoáng khí", 120000, 1, R.drawable.giay1, 38));
        dsGioHang.add(new sanpham("Humtto 670148A - Giày đi nước Trekking", 1200000, 1, R.drawable.giay1, 39));

        adapter = new adaptergiohang(this, R.layout.itemgiohang, dsGioHang);
        lvGioHang.setAdapter(adapter);
    }
}
