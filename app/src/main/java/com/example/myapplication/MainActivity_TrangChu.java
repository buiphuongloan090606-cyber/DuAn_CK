package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Giay.AdapterGiay;
import com.example.myapplication.Giay.Giay;

import java.util.ArrayList;

public class MainActivity_TrangChu extends AppCompatActivity {
    ListView lvGiay;
    ArrayList<Giay> dsGiay;
    AdapterGiay adapterGiay;
    Uri imgGiay;
    Button btn_user_danhMuc;
    Button TC_btn_gioHanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_trangchu);
        lvGiay = findViewById(R.id.user_lvTrangChu);
        TC_btn_gioHanh = findViewById(R.id.TC_btn_gioHanh);
        dsGiay = new ArrayList<>();

        Uri giay = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.nike);

        dsGiay.add(new Giay("Giày Nike Air Max", "Giày thể thao", "★★★★★ 4.8", 189000, giay));
        dsGiay.add(new Giay("Giày Nike Air Max", "Giày thể thao", "★★★★★ 4.8", 189000, giay));
        dsGiay.add(new Giay("Giày Nike Air Max", "Giày thể thao", "★★★★★ 4.8", 189000, giay));
        dsGiay.add(new Giay("Giày Nike Air Max", "Giày thể thao", "★★★★★ 4.8", 189000, giay));
        dsGiay.add(new Giay("Giày Nike Air Max", "Giày thể thao", "★★★★★ 4.8", 189000, giay));
        dsGiay.add(new Giay("Giày Nike Air Max", "Giày thể thao", "★★★★★ 4.8", 189000, giay));

        adapterGiay = new AdapterGiay(this, dsGiay);
        lvGiay.setAdapter(adapterGiay);

        btn_user_danhMuc=findViewById(R.id.btn_user_danhMuc);
        btn_user_danhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_danhMuc = new Intent(MainActivity_TrangChu.this, user_danhMuc.class);
                startActivity(intent_danhMuc);

            }
        });

        TC_btn_gioHanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_GioHang = new Intent(MainActivity_TrangChu.this, user_GioHang.class);
                startActivity(intent_GioHang);
            }
        });
        lvGiay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Giay giayChon = dsGiay.get(position);
                Intent intent_MoTa = new Intent(MainActivity_TrangChu.this, user_Mota.class);
                intent_MoTa.putExtra("tenGiay", giayChon.tenGiay);
                intent_MoTa.putExtra("loaiGiay", giayChon.loaiGiay);
                intent_MoTa.putExtra("giaGiay", giayChon.tvGiaGiay);
                if (giayChon.imgGiay != null) {
                    intent_MoTa.putExtra("imgGiay", giayChon.imgGiay.toString());
                }
                startActivity(intent_MoTa);
            }
        });

    }
}