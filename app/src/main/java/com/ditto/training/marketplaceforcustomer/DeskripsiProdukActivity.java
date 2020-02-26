package com.ditto.training.marketplaceforcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ditto.training.marketplaceforcustomer.Model.Product;

public class DeskripsiProdukActivity extends AppCompatActivity {

    public TextView tvNamaDesc, tvMerchantDesc, tvJumlahDesc, tvMiniNameDesc, tvMiniCategoryDesc;
    public TextView tvPriceDesc, tvProdDesc;
    public ImageView ivProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_produk);

        Product product = getIntent().getParcelableExtra("produk");
        findView();

        String namaProduk = product.getProductName();
        int jumlahProduk = product.getProductQty();
        int hargaProduk = product.getProductPrice();
        String deskripsiProduk = product.getProductDesc();
        String merchantProduk = product.getMerchant().getMerchantName();
        String kategoriProduk = product.getCategory().getCategoryName();
        String baseUrl = "http://210.210.154.65:4444/storage/";
        String url = baseUrl+product.getProductImage();

        tvNamaDesc.setText(namaProduk);
        tvMerchantDesc.setText(merchantProduk);
        tvJumlahDesc.setText(String.valueOf(jumlahProduk));
        tvPriceDesc.setText("Rp "+String.valueOf(hargaProduk));
        tvProdDesc.setText(deskripsiProduk);
        tvMiniNameDesc.setText(namaProduk);
        tvMiniCategoryDesc.setText(kategoriProduk);
        Glide.with(this).load(url).into(ivProduk);
    }

    public void findView(){
        ivProduk = findViewById(R.id.iv_deskripsi_produk);
        tvNamaDesc = findViewById(R.id.tv_deskripsi_nama_produk);
        tvMerchantDesc = findViewById(R.id.tv_deskripsi_nama_merchant);
        tvJumlahDesc = findViewById(R.id.tv_deskripsi_jumlah_produk);
        tvPriceDesc = findViewById(R.id.tv_deskripsi_harga_produk);
        tvProdDesc = findViewById(R.id.tv_deskripsi_produk_bottom);
        tvMiniNameDesc = findViewById(R.id.tv_deskripsi_mini_nama_produk);
        tvMiniCategoryDesc = findViewById(R.id.tv_deskripsi_mini_kategori_produk);
    }
}
