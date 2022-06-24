package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.jokol.databinding.ActivitySuccessfulPaymentBinding;
import com.example.jokol.main.MainActivity;

public class Successful_payment extends AppCompatActivity {

    ActivitySuccessfulPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessfulPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.thelayout.setOnClickListener(it-> {
            startActivity(new Intent(Successful_payment.this, MainActivity.class));
        });
    }
}