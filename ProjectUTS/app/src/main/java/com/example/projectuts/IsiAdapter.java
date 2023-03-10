package com.example.projectuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IsiAdapter extends RecyclerView.Adapter<IsiAdapter.IsiMenuList> {
    private Context c;
    private ArrayList nama, genre, platform, tahun, harga, deskripsi;
    private RecyclerViewClickListener click1;

    IsiAdapter(Context c, ArrayList nama, ArrayList genre, ArrayList platform, ArrayList tahun, ArrayList harga, ArrayList deskripsi, RecyclerViewClickListener click){
        this.c = c;
        this.nama = nama;
        this.genre = genre;
        this.platform = platform;
        this.tahun = tahun;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.click1=click;
    }

    @NonNull
    @Override
    public IsiMenuList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(c);
        View view = layoutinflater.inflate(R.layout.layoutlistview,parent,false);
        return new IsiMenuList(view, click1);
    }

    @Override
    public void onBindViewHolder(@NonNull IsiMenuList holder, int position) {
        holder.nama1.setText(String.valueOf(nama.get(position)));
        holder.genre1.setText(String.valueOf(genre.get(position)));
        holder.platform1.setText(String.valueOf(platform.get(position)));
        holder.tahun1.setText(String.valueOf(tahun.get(position)));
        holder.harga1.setText(String.valueOf(harga.get(position)));
        holder.deskripsi1.setText(String.valueOf(deskripsi.get(position)));
    }

    @Override
    public int getItemCount() {
        return nama.size();
    }

    public class IsiMenuList extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nama1,genre1,platform1,tahun1,harga1,deskripsi1;
        RecyclerViewClickListener click;

        public IsiMenuList(@NonNull View itemView, RecyclerViewClickListener click) {
            super(itemView);
            nama1=(TextView)itemView.findViewById(R.id.NamaGame);
            genre1=(TextView)itemView.findViewById(R.id.GenreGame);
            platform1=(TextView)itemView.findViewById(R.id.platformGame);
            tahun1=(TextView)itemView.findViewById(R.id.tahunrilisGame);
            harga1=(TextView)itemView.findViewById(R.id.hargaGame);
            deskripsi1=(TextView)itemView.findViewById(R.id.deskripsiGame);
            this.click = click;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            click.OnClick(getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void OnClick(int position);
    }
}
