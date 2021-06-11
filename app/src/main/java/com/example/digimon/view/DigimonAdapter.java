package com.example.digimon.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.digimon.R;
import com.example.digimon.model.DigimonModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DigimonAdapter extends RecyclerView.Adapter<DigimonAdapter.DigimonViewHolder> {

    private ArrayList<DigimonModel> digimonList = new ArrayList<>();
    private Context context;


    public DigimonAdapter(ArrayList<DigimonModel> items, Context context) {
        this.context = context;
        this.digimonList = items;
    }

    public DigimonAdapter() {
    }

    @NonNull
    @Override
    public DigimonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new DigimonViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull DigimonViewHolder holder, int position) {
        holder.digimon_name.setText(digimonList.get(position).getName());
        Glide.with(context).load(digimonList.get(position).getImg())
                .into(holder.digimon_img);
    }

    @Override
    public int getItemCount() {
        return digimonList.size();
    }

    public void setList(ArrayList<DigimonModel> moviesList) {
        this.digimonList = moviesList;
        notifyDataSetChanged();
    }

    public class DigimonViewHolder extends RecyclerView.ViewHolder {

        ImageView digimon_img;
        TextView digimon_name;
        public DigimonViewHolder(@NonNull View itemView) {
            super(itemView);
            digimon_img = itemView.findViewById(R.id.digimon_img);
            digimon_name = itemView.findViewById(R.id.digimon_name);


        }
    }
}

