package com.example.tugas4;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IsiAdapterMenu extends RecyclerView.Adapter<IsiAdapterMenu.IsiViewMenu> {

    private ArrayList<Listmenu> datalistmenu;
    private RecyclerViewClickListener rrecyclerViewClickListener;

    public IsiAdapterMenu(ArrayList<Listmenu> datalistmenu, RecyclerViewClickListener recyclerViewClickListener) {
        this.datalistmenu = datalistmenu;
        this.rrecyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public IsiViewMenu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View v = layoutinflater.inflate(R.layout.layoutgridmenu,parent,false);
        return new IsiViewMenu(v,rrecyclerViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull IsiViewMenu holder, int position) {
        final Listmenu listmenu = datalistmenu.get(position);
            holder.n.setText(datalistmenu.get(position).getNama());
            holder.t.setText(datalistmenu.get(position).getTahun());
            holder.f.setImageResource(datalistmenu.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return (datalistmenu!=null)?datalistmenu.size():0;
    }

    public class IsiViewMenu extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView n,t;
        private ImageView f;
        RecyclerViewClickListener recyclerViewClickListener;
        public IsiViewMenu(@NonNull View itemView, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemView);
            n=(TextView)itemView.findViewById(R.id.nama);
            t=(TextView)itemView.findViewById(R.id.Tahun);
            f=(ImageView)itemView.findViewById(R.id.imageViewFoto);
            this.recyclerViewClickListener = recyclerViewClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.OnClick(getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void OnClick(int position);
    }
}
