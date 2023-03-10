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

public class AdapterKaryawan extends RecyclerView.Adapter<AdapterKaryawan.ViewHolder> {
    private ArrayList<ListDataKaryawan> datalist;
    private Context c;
    private OnKaryawanListener mOnKaryawanListener;

    public AdapterKaryawan(ArrayList<ListDataKaryawan> datalist, Context c, OnKaryawanListener onKaryawanListener) {
        this.datalist = datalist;
        this.c = c;
        this.mOnKaryawanListener = onKaryawanListener;
    }

    @NonNull
    @Override
    public AdapterKaryawan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.layoutlistkaryawan,parent,false);
        return new ViewHolder(view, mOnKaryawanListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKaryawan.ViewHolder holder, int position) {
        final ListDataKaryawan listdatakaryawan = datalist.get(position);

        holder.nama1.setText(datalist.get(position).getNamakaryawan());
        holder.jabatan1.setText(datalist.get(position).getJabatan());
        holder.gaji1.setText(datalist.get(position).getGaji());
        holder.kode1.setText(datalist.get(position).getIdkaryawan());
        Glide.with(c).load(datalist.get(position).getImagekaryawan()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.gambar1);
    }

    @Override
    public int getItemCount() {
        return (datalist!=null)?datalist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView kode1,nama1,jabatan1,gaji1;
        private ImageView gambar1;
        OnKaryawanListener onKaryawanListener;
        public ViewHolder(@NonNull View itemView, OnKaryawanListener onKaryawanListener) {
            super(itemView);
            nama1=(TextView)itemView.findViewById(R.id.textViewNamaKaryawan);
            jabatan1=(TextView)itemView.findViewById(R.id.textViewJabatan);
            gaji1=(TextView)itemView.findViewById(R.id.textViewGaji);
            kode1=(TextView)itemView.findViewById(R.id.textViewIDKaryawan);
            gambar1=(ImageView)itemView.findViewById(R.id.imageViewListKaryawan);
            this.onKaryawanListener=onKaryawanListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onKaryawanListener.OnKaryawanClick(getAdapterPosition());
        }
    }
    public interface OnKaryawanListener{
        void OnKaryawanClick(int position);
    }
}
