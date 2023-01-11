package com.example.jokol.dummy;

import com.example.jokol.R;
import com.example.jokol.Shop;
import com.example.jokol.Transaction;

import java.util.ArrayList;

public class DummyTransaction {

    public static ArrayList<Transaction> translist = new ArrayList(){{
        add(new Transaction(R.drawable.valorant_logo_0, "Gorilla Team", "3", "45000"));
        add(new Transaction(R.drawable.valorant_logo, "Lion Team", "5", "75000"));
    }};

    public static ArrayList<TransactionModel> checkoutTransaction = new ArrayList<>();
//    public static Shop getTheShop(String title) {
//        Shop theShop = null;
//        for (Shop shop :
//                DummyShopDetail.shopList) {
//            if (shop.getShopName().equals(title)) {
//                theShop = shop;
//            }
//        }
//
//        return theShop;
//    }

}
