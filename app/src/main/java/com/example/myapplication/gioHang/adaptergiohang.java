package com.example.myapplication.gioHang;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

import com.example.myapplication.R;

import java.util.ArrayList;

public class adaptergiohang extends ArrayAdapter<sanpham> {

    public adaptergiohang(Context context, int resource, ArrayList<sanpham> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.itemgiohang, null);
        }

        sanpham sp = getItem(position);

        TextView tvTenSP = convertView.findViewById(R.id.tvTenSP);
        TextView tvGiaSP = convertView.findViewById(R.id.tvGiaSP);
        ImageView imgSanPham = convertView.findViewById(R.id.imgSanPham);
        TextView tvSoLuong = convertView.findViewById(R.id.tvSoLuong);
        TextView TVsize = convertView.findViewById(R.id.TVsize);

        // Sửa ép kiểu đúng với XML (TextView và ImageView)
        TextView btnGiam = convertView.findViewById(R.id.btnGiam);
        TextView btnTang = convertView.findViewById(R.id.btnTang);
        ImageView btnXoa = convertView.findViewById(R.id.btnXoa);

        tvTenSP.setText(sp.ten);
        tvGiaSP.setText(String.format("%,dđ", sp.gia));
        imgSanPham.setImageResource(sp.hinhAnh);
        tvSoLuong.setText(String.valueOf(sp.soLuong));
        TVsize.setText("Size: " + sp.size + " ▾");

        // Bấm vào Size để mở hộp thoại chọn lại
        TVsize.setOnClickListener(v -> {
            com.google.android.material.bottomsheet.BottomSheetDialog dialog =
                    new com.google.android.material.bottomsheet.BottomSheetDialog(getContext());
            View view = View.inflate(getContext(), R.layout.dialog_updatesp, null); // Nhớ đổi R.layout.dialog nếu file XML của bạn tên khác
            dialog.setContentView(view);
            dialog.show();


        });
        int thanhtien = sp.gia * sp.soLuong;
        tvGiaSP.setText(String.format("%,dđ", thanhtien));


        // Nút tăng số lượng
        btnTang.setOnClickListener(v -> {
            sp.soLuong++;
            notifyDataSetChanged();
        });

        // Nút giảm số lượng
        btnGiam.setOnClickListener(v -> {
            if (sp.soLuong > 1) {
                sp.soLuong--;
                notifyDataSetChanged();
            }
        });

        // Nút xóa sản phẩm
        btnXoa.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext())
                    .setTitle("Xóa sản phẩm")
                    .setMessage("Bạn có chắc chắn muốn xóa sản phẩm này?")
                    .setPositiveButton("Có", (dialog, which) -> {
                        remove(sp);
                        notifyDataSetChanged();
                    })
                    .setNegativeButton("Không", null)
                    .show();
        });

        return convertView;
    }
}