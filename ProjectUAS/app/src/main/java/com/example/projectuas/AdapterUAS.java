package com.example.projectuas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUAS extends RecyclerView.Adapter<AdapterUAS.ViewHolder> {
    private ArrayList<ListDataUAS> datalist;
    private Context c;

    public AdapterUAS(ArrayList<ListDataUAS> datalist, Context c) {
        this.datalist = datalist;
        this.c = c;
    }

    @NonNull
    @Override
    public AdapterUAS.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.layoutrecycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUAS.ViewHolder holder, int position) {
        final ListDataUAS listdatauser = datalist.get(position);

        holder.kode1.setText(datalist.get(position).getKode());
        holder.nama1.setText(datalist.get(position).getNama());
        holder.genre1.setText(datalist.get(position).getGenre());
        holder.platform1.setText(datalist.get(position).getPlatform());
        holder.harga1.setText(datalist.get(position).getHarga());
        holder.tahun1.setText(datalist.get(position).getTahun());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {

        return (datalist!=null)?datalist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView kode1,nama1,genre1,platform1,harga1,tahun1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kode1=(TextView)itemView.findViewById(R.id.Kode);
            nama1=(TextView)itemView.findViewById(R.id.Nama);
            genre1=(TextView)itemView.findViewById(R.id.Genre);
            platform1=(TextView)itemView.findViewById(R.id.Platform);
            harga1=(TextView)itemView.findViewById(R.id.Harga);
            tahun1=(TextView)itemView.findViewById(R.id.Tahun);
        }
    }
}
