package com.example.jokol;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    private List<Shop> shopList;
    private Context context;

    public ShopAdapter(List<Shop> shopList, Context context){
        this.shopList = shopList;
        this.context = context;
    }
    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item, parent, false);
        ShopViewHolder shopViewHolder = new ShopViewHolder(view);
        return shopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        holder.shopImage.setImageResource(shopList.get(position).getImage());
        holder.shopName.setText(shopList.get(position).getShopName());
        holder.price.setText(String.format("%d", shopList.get(position).getPrice()));
        holder.rateBar.setRating(shopList.get(position).getRateBar());
        holder.rate.setText(shopList.get(position).getRate());
        holder.user.setText(String.format("%d",shopList.get(position).getUser()));

        holder.shopImage.setOnClickListener(it -> {
            Intent newIntent = new Intent(context, ShopDetail.class);
            newIntent.putExtra("title", shopList.get(position).getShopName());
            context.startActivity(newIntent);
        });
    }

    @Override
    public int getItemCount() {

        return shopList.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder {

        private ImageView shopImage;
        private TextView shopName;
        private TextView price;
        private RatingBar rateBar;
        private TextView rate;
        private TextView user;
        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            shopImage = itemView.findViewById(R.id.shopLogo);
            shopName = itemView.findViewById(R.id.shopName);
            price = itemView.findViewById(R.id.price);
            rateBar = itemView.findViewById(R.id.rateBar);
            rate = itemView.findViewById(R.id.rate);
            user = itemView.findViewById(R.id.user);
        }
    }
}

