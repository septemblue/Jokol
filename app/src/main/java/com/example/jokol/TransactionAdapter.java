package com.example.jokol;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jokol.dummy.TransactionModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private ArrayList<TransactionModel> transList;
    private Context context;

    public TransactionAdapter(ArrayList<TransactionModel> transList, Context context){
        this.transList = transList;
        this.context = context;
    }
    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
        TransactionViewHolder transactionViewHolder = new TransactionViewHolder(view);
        return transactionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.TransactionViewHolder holder, int position) {
        int totalHarga = transList.get(position).shop.getPrice() * transList.get(position).quantity;
        holder.transImage.setImageResource(transList.get(position).shop.getImage());
        holder.transName.setText(transList.get(position).shop.getShopName());
        holder.transTotal.setText(String.format("%d", transList.get(position).quantity));
        holder.transPrice.setText(String.format("%d", totalHarga));

        holder.payButton.setOnClickListener(it -> {
            Intent newIntent = new Intent(context, metodePembayaran.class);
            newIntent.putExtra("totalharga", totalHarga);
            transList.remove(position);
            context.startActivity(newIntent);
        });
    }

    @Override
    public int getItemCount() {

        return transList.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {

        private ImageView transImage;
        private TextView transName;
        private TextView transTotal;
        private TextView transPrice;
        private AppCompatButton payButton;
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            payButton = itemView.findViewById(R.id.payBox);
            transImage = itemView.findViewById(R.id.transactionLogo);
            transName = itemView.findViewById(R.id.transactionName);
            transTotal = itemView.findViewById(R.id.transactionTotal);
            transPrice = itemView.findViewById(R.id.transactionPrice);
        }
    }
}
