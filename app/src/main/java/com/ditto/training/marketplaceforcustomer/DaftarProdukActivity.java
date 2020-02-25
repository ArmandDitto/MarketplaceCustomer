package com.ditto.training.marketplaceforcustomer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ditto.training.marketplaceforcustomer.Adapter.ListProductAdapter;
import com.ditto.training.marketplaceforcustomer.Model.ListProduct;
import com.ditto.training.marketplaceforcustomer.Model.Product;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DaftarProdukActivity extends AppCompatActivity {

    RecyclerView rvProduct;
    ListProductAdapter listProductAdapter;
    ArrayList<Product> data;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_produk);

        data = new ArrayList<>();
        rvProduct = findViewById(R.id.rv_list_produk);
        listProductAdapter = new ListProductAdapter(DaftarProdukActivity.this, data);

        rvProduct.setAdapter(listProductAdapter);
        rvProduct.setLayoutManager(new GridLayoutManager(DaftarProdukActivity.this, 2));

        VolleyLoad();
    }

    public void VolleyLoad(){
        requestQueue = Volley.newRequestQueue(this);
        String url = "http://210.210.154.65:4444/api/products/";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gsonData = new Gson();
                ListProduct listProduct = gsonData.fromJson(response.toString(),ListProduct.class);
                listProductAdapter.addData(listProduct.getListProduct());
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley Error", error.getMessage());
            }
        });

        requestQueue.add(request);
    }
}
