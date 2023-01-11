package com.example.jokol.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jokol.Login;
import com.example.jokol.Profile;
import com.example.jokol.R;
import com.example.jokol.TransactionPage;
import com.example.jokol.databinding.ActivityMainBinding;
import com.example.jokol.dummy.DummyGame;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView gamelistRecycleView;
    private SearchView searchView ;
    ActivityMainBinding binding;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        mAuth = FirebaseAuth.getInstance();
        setContentView(binding.getRoot());

        gamelistRecycleView = findViewById(R.id.rvGame);
        gamelistRecycleView.setHasFixedSize(true);
        gamelistRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        GameAdapter gameAdapter = new GameAdapter(DummyGame.games, MainActivity.this);
        gamelistRecycleView.setAdapter(gameAdapter);
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
                startActivity(new Intent(MainActivity.this, Profile.class));
                return true;
            } else if (it.getItemId() == R.id.ic_transaction) {
                startActivity(new Intent(MainActivity.this, TransactionPage.class));
                return true;
            }
            return false;
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}