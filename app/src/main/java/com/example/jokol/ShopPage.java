package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShopPage extends AppCompatActivity {

    private RecyclerView shoplistRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        shoplistRecycleView = findViewById(R.id.rvShop);
        shoplistRecycleView.setHasFixedSize(true);
        shoplistRecycleView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Shop> shopList = new ArrayList<>();
        shopList.add(new Shop(R.drawable.valorant_logo_0, "Gorilla Team", 15000, 3, "3", 10));
        shopList.add(new Shop(R.drawable.valorant_logo, "Lion Team", 15000, 4, "4", 6));

        ShopAdapter shopAdapter = new ShopAdapter(shopList);
        shoplistRecycleView.setAdapter(shopAdapter);
    }
}