package com.example.jokol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView gamelistRecycleView, shoplistRecycleView;
    private SearchView searchView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamelistRecycleView = findViewById(R.id.rvGame);
        gamelistRecycleView.setHasFixedSize(true);
        gamelistRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Game> gameList = new ArrayList<>();
        gameList.add(new Game(R.drawable.valorant_logo_0, "Valorant"));
        gameList.add(new Game(R.drawable.valorant_logo, "Valorant"));
        gameList.add(new Game(R.drawable.valorant_logo, "Valorant"));
        gameList.add(new Game(R.drawable.valorant_logo, "Valorant"));
        gameList.add(new Game(R.drawable.valorant_logo, "Valorant"));

        GameAdapter gameAdapter = new GameAdapter(gameList);
        gamelistRecycleView.setAdapter(gameAdapter);

//        ImageView valorant = findViewById(R.id.valorant);
//        valorant.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ShopPage.class);
//                startActivity(intent);
//            }
//        });
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

    @Override
    public void onClick(View view) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}