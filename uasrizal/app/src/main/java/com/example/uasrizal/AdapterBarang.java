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

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ViewHolder> {
    private ArrayList<ListDataBarang> datalist;
    private OnBarangListener mOnBarangListener;
    private Context c;

    public AdapterBarang(ArrayList<ListDataBarang> datalist, Context c,OnBarangListener onBarangListener) {
        this.datalist = datalist;
        this.c = c;
        this.mOnBarangListener = onBarangListener;
    }

    @NonNull
    @Override
    public AdapterBarang.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.layoutlistbarang,parent,false);
        return new ViewHolder(view, mOnBarangListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBarang.ViewHolder holder, int position) {
        final ListDataBarang listdatabarang = datalist.get(position);

        holder.nama1.setText(datalist.get(position).getNama());
        holder.kelas1.setText(datalist.get(position).getKelas());
        holder.alamat1.setText(datalist.get(position).getAlamat());
        holder.kode1.setText(datalist.get(position).getKode());
        Glide.with(c).load(datalist.get(position).getImage()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.gambar1);
        //.thumbnail(0.5f).crossFade()
    }

    @Override
    public int getItemCount() {
        return (datalist!=null)?datalist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView kode1,nama1,alamat1,kelas1;
        private ImageView gambar1;
        OnBarangListener onBarangListener;
        public ViewHolder(@NonNull View itemView, OnBarangListener onBarangListener) {
            super(itemView);
            nama1=(TextView)itemView.findViewById(R.id.textViewNamaGame);
            kelas1=(TextView)itemView.findViewById(R.id.textViewDeskripsiGame);
            alamat1=(TextView)itemView.findViewById(R.id.textViewHargaGame);
            kode1=(TextView)itemView.findViewById(R.id.textViewID);
            gambar1=(ImageView)itemView.findViewById(R.id.imageViewListBarang);
            this.onBarangListener = onBarangListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onBarangListener.OnBarangClick(getAdapterPosition());
        }
    }

    public interface OnBarangListener{
        void OnBarangClick(int position);
    }
}
