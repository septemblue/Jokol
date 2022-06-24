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

        String title = extras.getString("title");
        int quantity = extras.getInt("quantity");

        binding.gopayBtn.setOnClickListener(it -> {
            Intent newIntent = new Intent(metodePembayaran.this, Payment.class);
            newIntent.putExtra("title", title);
            newIntent.putExtra("quantity", quantity);
            startActivity(newIntent);
        });

        binding.ovoBtn.setOnClickListener(it -> {
            Intent newIntent = new Intent(metodePembayaran.this, Payment.class);
            newIntent.putExtra("title", title);
            startActivity(newIntent);
        });
    }
}