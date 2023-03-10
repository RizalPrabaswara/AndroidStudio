package com.example.proyekuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.IsiAdapter> {

    private Context c;
    private ArrayList nama, tempat, kategori, rating, harga;
    private RecycleViewClickListener recycleViewClickListener;

    public Adapter(Context c, ArrayList nama, ArrayList tempat, ArrayList kategori, ArrayList rating, ArrayList harga, RecycleViewClickListener recycleViewClickListener) {
        this.c = c;
        this.nama = nama;
        this.tempat = tempat;
        this.kategori = kategori;
        this.rating = rating;
        this.harga = harga;
        this.recycleViewClickListener = recycleViewClickListener;
    }

    @NonNull
    @Override
    public Adapter.IsiAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layoutlistmenu,parent,false);
        return new IsiAdapter(view, recycleViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.IsiAdapter holder, int position) {
        holder.nama.setText(String.valueOf(nama.get(position)));
        holder.tempat.setText(String.valueOf(tempat.get(position)));
        holder.kategori.setText(String.valueOf(kategori.get(position)));
        holder.rating.setText(String.valueOf(rating.get(position)));
        holder.harga.setText(String.valueOf(harga.get(position)));
    }

    @Override
    public int getItemCount() {
        return nama.size();
    }

    public class IsiAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nama, tempat, kategori, rating, harga;
        private RecycleViewClickListener recycleViewClickListener;

        public IsiAdapter(@NonNull View itemView, RecycleViewClickListener recycleViewClickListener) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.txtNama);
            tempat = (TextView)itemView.findViewById(R.id.txtTempat);
            kategori = (TextView)itemView.findViewById(R.id.txtKategori);
            rating = (TextView)itemView.findViewById(R.id.txtRating);
            harga = (TextView)itemView.findViewById(R.id.txtHarga);
            this.recycleViewClickListener = recycleViewClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recycleViewClickListener.Onclick(getAdapterPosition());
        }
    }

    public interface RecycleViewClickListener{
        void Onclick(int position);
    }

}
