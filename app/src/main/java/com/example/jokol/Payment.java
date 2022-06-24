package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jokol.databinding.ActivityPaymentBinding;
import com.example.jokol.dummy.DummyShopDetail;

public class Payment extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = null;

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
        }

        String title = extras.getString("title");
        int quantity = extras.getInt("quantity");

        Shop shop = DummyShopDetail.getTheShop(title);

        binding.jumlahHarga.setText(String.format("%d", shop.getPrice() * quantity));

        binding.klik.setOnClickListener(it -> {
            startActivity(new Intent(Payment.this, Successful_payment.class));
        });
    }
}