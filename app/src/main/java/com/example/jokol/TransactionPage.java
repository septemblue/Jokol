package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.example.jokol.databinding.ActivityShopPageBinding;
import com.example.jokol.dummy.DummyShopDetail;
import com.example.jokol.dummy.DummyTransaction;

public class TransactionPage extends AppCompatActivity {

    private RecyclerView translistRecycleView;
    private SearchView searchView ;
    ActivityShopPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShopPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        translistRecycleView = findViewById(R.id.rvTransaction);
        translistRecycleView.setHasFixedSize(true);
        translistRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        TransactionAdapter transactionAdapter = new ShopAdapter(DummyTransaction.translist, ShopPage.this);
        translistRecycleView.setAdapter(transactionAdapter);
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
}