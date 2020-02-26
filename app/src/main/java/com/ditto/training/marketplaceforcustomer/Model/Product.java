package com.ditto.training.marketplaceforcustomer.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int productId;
    private String productName;
    private String productSlug;
    private int productQty;
    private String productImage;
    private int productPrice;
    private String productDesc;
    private Merchant merchant;
    private Category category;

    public Product(int productId, String productName, String productSlug, int productQty, String productImage, int productPrice, String productDesc, Merchant merchant, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productSlug = productSlug;
        this.productQty = productQty;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.merchant = merchant;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSlug() {
        return productSlug;
    }

    public int getProductQty() {
        return productQty;
    }

    public String getProductImage() {
        return productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public Category getCategory() {
        return category;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.productId);
        dest.writeString(this.productName);
        dest.writeString(this.productSlug);
        dest.writeInt(this.productQty);
        dest.writeString(this.productImage);
        dest.writeInt(this.productPrice);
        dest.writeString(this.productDesc);
        dest.writeParcelable(this.merchant, flags);
        dest.writeParcelable(this.category, flags);
    }

    protected Product(Parcel in) {
        this.productId = in.readInt();
        this.productName = in.readString();
        this.productSlug = in.readString();
        this.productQty = in.readInt();
        this.productImage = in.readString();
        this.productPrice = in.readInt();
        this.productDesc = in.readString();
        this.merchant = in.readParcelable(Merchant.class.getClassLoader());
        this.category = in.readParcelable(Category.class.getClassLoader());
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
