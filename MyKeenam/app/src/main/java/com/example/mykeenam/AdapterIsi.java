package com.example.mykeenam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class AdapterIsi extends RecyclerView.Adapter<AdapterIsi.IsiViewHolder> {
    private ArrayList<Listisi> datalistisi;

    public AdapterIsi(ArrayList<Listisi> datalistisi) {

        this.datalistisi = datalistisi;
    }

    @NonNull
    @Override
    public IsiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View v = layoutinflater.inflate(R.layout.layoutisi,parent,false);
        return new IsiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IsiViewHolder holder, int position) {
        final Listisi listisi = datalistisi.get(position);
            holder.n.setText(datalistisi.get(position).getNama());
            holder.a.setText(datalistisi.get(position).getAlamat());
            holder.t.setText(datalistisi.get(position).getTelp());
            holder.f.setImageResource(datalistisi.get(position).getFoto());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),listisi.getNama(),Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public int getItemCount() {

        return (datalistisi!=null)?datalistisi.size():0;
    }

    public class IsiViewHolder extends RecyclerView.ViewHolder {
        private TextView n,a,t;
        private ImageView f;
        public IsiViewHolder(@NonNull View itemView) {
            super(itemView);
            n=(TextView)itemView.findViewById(R.id.nama);
            a=(TextView)itemView.findViewById(R.id.alamat);
            t=(TextView)itemView.findViewById(R.id.telepon);
            f=(ImageView)itemView.findViewById(R.id.imageViewFoto);
        }
    }
}
