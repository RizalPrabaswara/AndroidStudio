package com.example.uasrizal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class AdapterBackground extends RecyclerView.Adapter<AdapterBackground.ViewHolder>{
    private ArrayList<Listbackground> datalistbackground;

    public AdapterBackground(ArrayList<Listbackground> datalistbackground) {
        this.datalistbackground = datalistbackground;
    }

    @NonNull
    @Override
    public AdapterBackground.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View v = layoutinflater.inflate(R.layout.layoutbackground,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBackground.ViewHolder holder, int position) {
        final Listbackground listbackground = datalistbackground.get(position);
        holder.g.setImageResource(datalistbackground.get(position).getGambar());
    }

    @Override
    public int getItemCount() {
        return (datalistbackground!=null)?datalistbackground.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView g;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            g=(ImageView)itemView.findViewById(R.id.imageViewBackground);
        }
    }
}
