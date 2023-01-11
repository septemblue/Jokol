package com.example.jokol.dummy;

import com.example.jokol.R;
import com.example.jokol.main.Game;

import java.util.ArrayList;

public class DummyGame {
    public static ArrayList<Game> games = new ArrayList(){{
        add(new Game(R.drawable.valorant_logo, "Valorant"));
    }};
}
