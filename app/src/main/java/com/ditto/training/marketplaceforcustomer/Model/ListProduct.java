package com.ditto.training.marketplaceforcustomer.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListProduct {
    @SerializedName("data")
    private ArrayList<Product> listProduct;

    public ListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }
}
