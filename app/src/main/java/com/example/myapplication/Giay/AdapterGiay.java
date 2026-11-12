package com.example.myapplication.Giay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;

public class AdapterGiay extends ArrayAdapter<Giay> {

    public AdapterGiay(@NonNull Context context, ArrayList<Giay>ds) {
        super(context, R.layout.itemsp,ds);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemsp, parent,false);
        }
        Giay shoe = getItem(position);
        TextView tenGiay = convertView.findViewById(R.id.tenGiay);
        TextView loaiGiay = convertView.findViewById(R.id.loaiGiay);
        TextView DanhGia = convertView.findViewById(R.id.DanhGia);
        TextView tvGiaGiay = convertView.findViewById(R.id.tvGiaGiay);
        ImageView imgGiay = convertView.findViewById(R.id.imgGiay);


        tenGiay.setText(shoe.tenGiay);
        loaiGiay.setText(shoe.loaiGiay);
        DanhGia.setText(shoe.DanhGia);
        tvGiaGiay.setText(String.valueOf(shoe.tvGiaGiay));
        if(shoe !=null){


            imgGiay.setImageURI(shoe.imgGiay);
        }else{
            imgGiay.setImageResource(android.R.drawable.ic_menu_gallery);
        }

        return convertView;
    }
}
