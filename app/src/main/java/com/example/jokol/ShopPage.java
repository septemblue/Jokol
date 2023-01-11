package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
=======
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.example.jokol.databinding.ActivityShopPageBinding;
import com.example.jokol.dummy.DummyShopDetail;
import com.example.jokol.main.MainActivity;
>>>>>>> developOne

import java.util.ArrayList;
import java.util.List;

public class ShopPage extends AppCompatActivity {

    private RecyclerView shoplistRecycleView;
<<<<<<< HEAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);
=======
    private SearchView searchView ;
    ActivityShopPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShopPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
>>>>>>> developOne

        shoplistRecycleView = findViewById(R.id.rvShop);
        shoplistRecycleView.setHasFixedSize(true);
        shoplistRecycleView.setLayoutManager(new GridLayoutManager(this, 2));

<<<<<<< HEAD
        List<Shop> shopList = new ArrayList<>();
        shopList.add(new Shop(R.drawable.valorant_logo_0, "Gorilla Team", 15000, 3, "3", 10));
        shopList.add(new Shop(R.drawable.valorant_logo, "Lion Team", 15000, 4, "4", 6));

        ShopAdapter shopAdapter = new ShopAdapter(shopList);
        shoplistRecycleView.setAdapter(shopAdapter);
    }
=======
        ShopAdapter shopAdapter = new ShopAdapter(DummyShopDetail.shopList, ShopPage.this);
        shoplistRecycleView.setAdapter(shopAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
>>>>>>> developOne
}