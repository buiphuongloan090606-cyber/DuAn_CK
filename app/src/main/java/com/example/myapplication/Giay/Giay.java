package com.example.myapplication.Giay;

import android.net.Uri;

public class Giay {
    public String tenGiay;
    public String loaiGiay;
    public String DanhGia;
    public long tvGiaGiay;
    public Uri imgGiay;

    public Giay(String tenGiay, String loaiGiay, String danhGia, long tvGiaGiay, Uri imgGiay) {
        this.tenGiay = tenGiay;
        this.loaiGiay = loaiGiay;
        this.DanhGia = danhGia;
        this.tvGiaGiay = tvGiaGiay;
        this.imgGiay = imgGiay;
    }
}
