package com.ditto.training.marketplaceforcustomer.Model;

import java.util.List;

public class ListProduct {
    private List<Product> listProduct;

    public ListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }
}
