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

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder>
{
    private ArrayList<ListDataUser> datalist;
    private Context c;

    public AdapterUser(ArrayList<ListDataUser> datalist, Context c) {
        this.datalist = datalist;
        this.c = c;
    }

    @NonNull
    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View view = layoutinflater.inflate(R.layout.layoutisi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.ViewHolder holder, int position) {
        final ListDataUser listuser = datalist.get(position);

        holder.kode1.setText(datalist.get(position).getKode());
        holder.nama1.setText(datalist.get(position).getNama());
        holder.alamat1.setText(datalist.get(position).getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah =new Intent(c,MainActivity.class);
                pindah.putExtra("kode",listuser.getKode());
                pindah.putExtra("nama",listuser.getNama());
                pindah.putExtra("alamat",listuser.getAlamat());
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
            kode1=(TextView)itemView.findViewById(R.id.Kode);
            nama1=(TextView)itemView.findViewById(R.id.Nama);
            alamat1=(TextView)itemView.findViewById(R.id.Alamat);
        }
    }
}
