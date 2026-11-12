package com.example.myapplication.Giay;

import android.net.Uri;

public class Giay {
    String tenGiay;
    String loaiGiay;
    String DanhGia;
    long tvGiaGiay;
    Uri imgGiay;

    public Giay(String tenGiay, String loaiGiay, String danhGia, long tvGiaGiay, Uri imgGiay) {
        this.tenGiay = tenGiay;
        this.loaiGiay = loaiGiay;
        this.DanhGia = danhGia;
        this.tvGiaGiay = tvGiaGiay;
        this.imgGiay = imgGiay;
    }
}
