package com.example.tugas4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IsiAdapterbackground extends RecyclerView.Adapter<IsiAdapterbackground.IsiViewBackground> {

    private ArrayList<Listbackground> datalistbackground;

    public IsiAdapterbackground(ArrayList<Listbackground> datalistbackground) {
        this.datalistbackground = datalistbackground;
    }

    @NonNull
    @Override
    public IsiAdapterbackground.IsiViewBackground onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        View v = layoutinflater.inflate(R.layout.layoutbackground,parent,false);
        return new IsiViewBackground(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IsiAdapterbackground.IsiViewBackground holder, int position) {
        final Listbackground listbackground = datalistbackground.get(position);
            holder.g.setImageResource(datalistbackground.get(position).getGambar());
    }

    @Override
    public int getItemCount() {
        return (datalistbackground!=null)?datalistbackground.size():0;
    }

    public class IsiViewBackground extends RecyclerView.ViewHolder {
        private ImageView g;
        public IsiViewBackground(@NonNull View itemView) {
            super(itemView);
            g=(ImageView)itemView.findViewById(R.id.imageViewBackground);
        }
    }
}
