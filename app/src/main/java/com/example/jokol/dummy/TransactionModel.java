package com.example.jokol.dummy;

import com.example.jokol.Shop;

public class TransactionModel {
    public Shop shop;
    public int quantity;

    public TransactionModel(Shop shop, int quantity) {
        this.shop = shop;
        this.quantity = quantity;
    }
}
