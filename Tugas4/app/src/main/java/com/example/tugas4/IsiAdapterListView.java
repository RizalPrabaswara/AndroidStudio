package com.example.tugas4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IsiAdapterListView extends RecyclerView.Adapter<IsiAdapterListView.IsiViewList> {

    private ArrayList<Listmenuview> datamenulistview;

    public IsiAdapterListView(ArrayList<Listmenuview> datamenulistview) {
        this.datamenulistview = datamenulistview;
    }

    @NonNull
    @Override
    public IsiViewList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View v = layoutinflater.inflate(R.layout.layoutlistmenu,parent,false);
        return new IsiViewList(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IsiViewList holder, int position) {
        final Listmenuview listmenuview = datamenulistview.get(position);
            holder.jb.setText(datamenulistview.get(position).getJ());
            holder.tb.setText(datamenulistview.get(position).getTb());
            holder.gb.setImageResource(datamenulistview.get(position).getGb());
    }

    @Override
    public int getItemCount() {
        return (datamenulistview!=null)?datamenulistview.size():0;
    }

    public class IsiViewList extends RecyclerView.ViewHolder {
        private TextView jb,tb;
        private ImageView gb;
        public IsiViewList(@NonNull View itemView) {
            super(itemView);
            jb=(TextView)itemView.findViewById(R.id.judulbuku);
            tb=(TextView)itemView.findViewById(R.id.tahunbuku);
            gb=(ImageView)itemView.findViewById(R.id.imageViewGambarBuku);
        }
    }
}
