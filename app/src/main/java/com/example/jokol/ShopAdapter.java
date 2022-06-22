package com.example.jokol;

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

    public ShopAdapter(List<Shop> shopList){
        this.shopList = shopList;
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
        holder.price.setText(shopList.get(position).getPrice());
        holder.rateBar.setRating(shopList.get(position).getRateBar());
        holder.rate.setText(shopList.get(position).getRate());
        holder.user.setText(shopList.get(position).getUser());
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

