package com.example.jokol;

import static com.example.jokol.dummy.DummyShopDetail.getTheShop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.jokol.databinding.ActivityShopDetailBinding;
import com.example.jokol.dummy.DummyTransaction;
import com.example.jokol.dummy.TransactionModel;

public class ShopDetail extends AppCompatActivity {

    ActivityShopDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShopDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = null;

        if (savedInstanceState == null) {
             extras = getIntent().getExtras();
        }


        String title = extras.getString("title");


        Log.i("theshoptitle", title);
        Shop shopDetail = getTheShop(title);
        Log.i("thesop", shopDetail.toString());
        binding.detailImage.setImageResource(shopDetail.getImage());
        binding.detailDescription.setText(shopDetail.getDescription());
        binding.detailPrice.setText(String.format("%d", shopDetail.getPrice()));
        binding.detailTitle.setText(shopDetail.getShopName());
        binding.detailUser.setText(String.format("%d", shopDetail.getUser()));

        binding.numPick.setMinValue(0);
        binding.numPick.setMaxValue(50);

        binding.checkoutBtn.setOnClickListener(it -> {
            Intent intent = new Intent(ShopDetail.this, TransactionPage.class);
            DummyTransaction.checkoutTransaction.add( new TransactionModel(shopDetail, binding.numPick.getValue()));
            intent.putExtra("title", shopDetail.getShopName());
            intent.putExtra("quantity", binding.numPick.getValue());
            startActivity(intent);
        });
    }


}