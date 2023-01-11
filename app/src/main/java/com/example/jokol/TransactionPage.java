package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.jokol.databinding.ActivityShopPageBinding;
import com.example.jokol.databinding.ActivityTransactionPageBinding;
import com.example.jokol.dummy.DummyShopDetail;
import com.example.jokol.dummy.DummyTransaction;
import com.example.jokol.main.MainActivity;

import java.util.List;

public class TransactionPage extends AppCompatActivity {

    private RecyclerView translistRecycleView;
    private SearchView searchView ;
    ActivityTransactionPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransactionPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvTransaction.setHasFixedSize(true);
        binding.rvTransaction.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        TransactionAdapter transactionAdapter = new TransactionAdapter(DummyTransaction.checkoutTransaction, TransactionPage.this);
        binding.rvTransaction.setAdapter(transactionAdapter);
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

        binding.btmNav.setOnItemSelectedListener(it -> {
            if (it.getItemId() == R.id.ic_profile) {
                startActivity(new Intent(TransactionPage.this, Profile.class));
                return true;
            } else if (it.getItemId() == R.id.ic_home) {
                startActivity(new Intent(TransactionPage.this, MainActivity.class));
                return true;
            }
            return false;
        });

        return super.onCreateOptionsMenu(menu);
    }
}