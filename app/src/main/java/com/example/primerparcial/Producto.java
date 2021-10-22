package com.example.primerparcial;

import androidx.annotation.NonNull;

public class Producto {

    private String nameProduct;
    private Integer count;
    private Double price;

    public Producto(){}

    public Producto(String nameProduct, Integer count, Double price) {
        this.nameProduct = nameProduct;
        this.count = count;
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return "soy toString " + this.nameProduct + this.count;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
