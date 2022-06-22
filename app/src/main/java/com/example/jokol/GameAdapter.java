package com.example.jokol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private List<Game> gameList;

    public GameAdapter(List<Game> gameList){

        this.gameList = gameList;
    }
    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
        GameViewHolder gameViewHolder = new GameViewHolder(view);
//        gameViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(parent.getContext(), GameDetail.class);
//                Game game = new Game();
//                game.setImage(gameList.get(gameViewHolder.getBinding));
//            }
//        });
        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.gamename.setText(gameList.get(position).getOffer());
        holder.gameimage.setImageResource(gameList.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return gameList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        private TextView gamename;
        private ImageView gameimage;
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);

            gameimage = itemView.findViewById(R.id.gameLogo);
            gamename = itemView.findViewById((R.id.gameName));
        }
    }
}
