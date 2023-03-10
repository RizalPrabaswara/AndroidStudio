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

public class AdapterSupplier extends RecyclerView.Adapter<AdapterSupplier.ViewHolder> {
    private ArrayList<ListDataSupplier> datalist;
    private OnSupplierListener mOnSupplierListener;
    private Context c;

    public AdapterSupplier(ArrayList<ListDataSupplier> datalist, Context c, OnSupplierListener onSupplierListener) {
        this.datalist = datalist;
        this.c = c;
        this.mOnSupplierListener = onSupplierListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.layoutlistsupplier,parent,false);
        return new ViewHolder(view, mOnSupplierListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListDataSupplier listdatasupplier = datalist.get(position);

        holder.nama1.setText(datalist.get(position).getNamasupplier());
        holder.notelepon1.setText(datalist.get(position).getNotelepon());
        holder.namabarang1.setText(datalist.get(position).getNamabarang());
        holder.kode1.setText(datalist.get(position).getIdsupplier());
        Glide.with(c).load(datalist.get(position).getImagesupplier()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.gambar1);
    }

    @Override
    public int getItemCount() {
        return (datalist!=null)?datalist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView kode1,nama1,notelepon1,namabarang1;
        private ImageView gambar1;
        OnSupplierListener onSupplierListener;
        public ViewHolder(@NonNull View itemView, OnSupplierListener onSupplierListener) {
            super(itemView);
            nama1=(TextView)itemView.findViewById(R.id.textViewNamaSupplier);
            notelepon1=(TextView)itemView.findViewById(R.id.textViewNoTelepon);
            namabarang1=(TextView)itemView.findViewById(R.id.textViewNamaBarang);
            kode1=(TextView)itemView.findViewById(R.id.textViewIDSupplier);
            gambar1=(ImageView)itemView.findViewById(R.id.imageViewListSupplier);
            this.onSupplierListener = onSupplierListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSupplierListener.OnSupplierClick(getAdapterPosition());
        }
    }
    public interface OnSupplierListener{
        void OnSupplierClick(int position);
    }
}
