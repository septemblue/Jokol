package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jokol.databinding.ActivityMetodePembayaranBinding;
import com.example.jokol.dummy.DummyShopDetail;

public class metodePembayaran extends AppCompatActivity {

    ActivityMetodePembayaranBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMetodePembayaranBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = null;

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
        }

        int totalHarga = extras.getInt("totalharga");

        binding.gopayBtn.setOnClickListener(it -> {
            Intent newIntent = new Intent(metodePembayaran.this, Payment.class);
            newIntent.putExtra("totalharga", totalHarga);
            startActivity(newIntent);
        });

        binding.ovoBtn.setOnClickListener(it -> {
            Intent newIntent = new Intent(metodePembayaran.this, Payment.class);
            newIntent.putExtra("totalharga", totalHarga);
            startActivity(newIntent);
        });
    }
}