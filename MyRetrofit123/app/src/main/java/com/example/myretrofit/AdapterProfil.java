package com.example.myretrofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterProfil extends RecyclerView.Adapter<AdapterProfil.ViewHolder>  {
    private ArrayList<ListDataProfil> datalist;
    private Context c;

    public AdapterProfil(ArrayList<ListDataProfil> datalist, Context c) {
        this.datalist = datalist;
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.layoutisi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final ListDataProfil Listdataprofil =datalist.get(position);

       holder.kode1.setText(datalist.get(position).getKode());
        holder.nama1.setText(datalist.get(position).getNama());
        holder.alamat1.setText(datalist.get(position).getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah =new Intent(c,MainActivity.class);
                pindah.putExtra("kode",Listdataprofil.getKode());
                pindah.putExtra("nama",Listdataprofil.getNama());
                pindah.putExtra("alamat",Listdataprofil.getAlamat());
                c.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (datalist!=null)?datalist.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView kode1,nama1,alamat1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kode1=(TextView)itemView.findViewById(R.id.textViewKode);
            nama1=(TextView)itemView.findViewById(R.id.textViewNama);
            alamat1=(TextView)itemView.findViewById(R.id.textViewAlamat);
        }
    }
}
