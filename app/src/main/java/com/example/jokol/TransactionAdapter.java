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

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private List<Transaction> transList;
    private Context context;

    public TransactionAdapter(List<Transaction> transList, Context context){
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
        holder.transImage.setImageResource(transList.get(position).getTransImage());
        holder.transName.setText(transList.get(position).getTransName());
        holder.transTotal.setText(transList.get(position).getTransTotal());
        holder.transPrice.setText(transList.get(position).getTransPrice());
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
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            transImage = itemView.findViewById(R.id.transactionLogo);
            transName = itemView.findViewById(R.id.transactionName);
            transTotal = itemView.findViewById(R.id.transactionTotal);
            transPrice = itemView.findViewById(R.id.transactionPrice);
        }
    }
}
