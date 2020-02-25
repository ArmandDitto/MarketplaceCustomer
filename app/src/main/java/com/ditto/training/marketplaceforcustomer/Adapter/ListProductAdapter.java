package com.ditto.training.marketplaceforcustomer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ditto.training.marketplaceforcustomer.Model.Product;
import com.ditto.training.marketplaceforcustomer.R;

import java.util.ArrayList;
import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ListProductViewHolder> {

    Context context;
    List<Product> listProductku;

    public ListProductAdapter(Context context, List<Product> listProductku) {
        this.context = context;
        this.listProductku = listProductku;
    }

    public ListProductAdapter(Context context) {
        this.context = context;
    }

    public void addData(ArrayList<Product> listProductku) {
        this.listProductku = listProductku;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewku;
        viewku = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produk, parent, false);
        return new ListProductViewHolder(viewku);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductViewHolder holder, int position) {
        holder.tvNamaProduk.setText(listProductku.get(position).getProductName());
        holder.tvNamaMerchant.setText(listProductku.get(position).getMerchant().getMerchantName());

        /*String baseUrl = "http://210.210.154.65:4444/storage";
        String url = baseUrl+listProductku.get(position).getProductImage();
        Glide.with(context).load(url).into(holder.ivProduk);*/
    }

    @Override
    public int getItemCount() {
        return listProductku.size();
    }

    public class ListProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProduk;
        public TextView tvNamaProduk, tvNamaMerchant;

        public ListProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduk = itemView.findViewById(R.id.iv_product);
            tvNamaProduk = itemView.findViewById(R.id.tv_product_name);
            tvNamaMerchant = itemView.findViewById(R.id.tv_merchant_name);
        }
    }
}
