package com.example.jokol.dummy;

import com.example.jokol.R;
import com.example.jokol.Shop;

import java.util.ArrayList;
import java.util.List;

public class DummyShopDetail {

    public static ArrayList<Shop> shopList = new ArrayList(){{
        add(new Shop(R.drawable.valorant_logo_0, "Gorilla Team", 15000, 3.5F, "3", 10, "Mantul kamu"));
        add(new Shop(R.drawable.valorant_logo, "Lion Team", 15000, 4, "4", 6, "Mantap Bang"));
    }};

    public static Shop getTheShop(String title) {
        Shop theShop = null;
        for (Shop shop :
                DummyShopDetail.shopList) {
            if (shop.getShopName().equals(title)) {
                theShop = shop;
            }
        }

        return theShop;
    }

}
