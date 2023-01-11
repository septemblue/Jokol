package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.os.Bundle;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
=======
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

        int totalharga = extras.getInt("totalharga");

        binding.jumlahHarga.setText(String.format("%d", totalharga));

        binding.klik.setOnClickListener(it -> {
            startActivity(new Intent(Payment.this, Successful_payment.class).putExtra("totalharga", totalharga));
        });
>>>>>>> developOne
    }
}