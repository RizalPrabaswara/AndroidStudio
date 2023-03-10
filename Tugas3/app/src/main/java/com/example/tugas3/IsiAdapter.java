package com.example.tugas3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IsiAdapter extends BaseAdapter {
    Context c;
    String nama[],keterangan[];
    int gambar[];
    LayoutInflater layout;

    public IsiAdapter(Context c, String[] nama, String[] keterangan, int[] gambar) {
        this.c = c;
        this.nama = nama;
        this.keterangan = keterangan;
        this.gambar = gambar;
        this.layout = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return nama.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layout.inflate(R.layout.layoutgridview, null);
        TextView n = (TextView) convertView.findViewById(R.id.textViewNama);
        TextView k = (TextView) convertView.findViewById(R.id.textViewKeterangan);
        ImageView f = (ImageView) convertView.findViewById(R.id.imageViewProgram);
        n.setText(nama[position]);
        k.setText(keterangan[position]);
        f.setImageResource(gambar[position]);

        return convertView;
    }
}
