package com.example.islamgsayed.firstapp;

public class CartItem {
    public product product;
    public int quantity;

    public CartItem(com.example.islamgsayed.firstapp.product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public com.example.islamgsayed.firstapp.product getProduct() {
        return product;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(com.example.islamgsayed.firstapp.product product) {
        this.product = product;
    }
}
