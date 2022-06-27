package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {
    private ArrayList<Theater> listTheater;

    public TheaterAdapter(ArrayList<Theater> listTheater) {
        this.listTheater = listTheater;
    }

    @NonNull
    @Override
    public TheaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theater, parent, false);
        return new TheaterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheaterAdapter.TheaterViewHolder holder, int position) {
        Theater theater = listTheater.get(position);
        holder.tvName.setText(theater.getName());
        holder.tvAddress.setText(theater.getAddress());
    }

    @Override
    public int getItemCount() {
        return listTheater.size();
    }

    public class TheaterViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress;

        public TheaterViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvAddress = itemView.findViewById(R.id.tv_item_address);
        }
    }
}
