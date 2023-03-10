package com.example.tugas3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IsiAdapterList extends BaseAdapter {
    Context c;
    String namabuku[],tahunbuku[];
    int icon[];
    LayoutInflater z;

    public IsiAdapterList(Context c, String[] namabuku, String[] tahunbuku, int[] icon) {
        this.c = c;
        this.namabuku = namabuku;
        this.tahunbuku = tahunbuku;
        this.icon = icon;
        this.z = (LayoutInflater.from(c));
    }

    @Override
    public int getCount() {
        return namabuku.length;
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
        convertView = z.inflate(R.layout.layoutlistview, null);
        TextView nb = (TextView) convertView.findViewById(R.id.textViewNamaBuku);
        TextView tb = (TextView) convertView.findViewById(R.id.textViewTahunBuku);
        ImageView i = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        nb.setText(namabuku[position]);
        tb.setText(tahunbuku[position]);
        i.setImageResource(icon[position]);

        return convertView;
    }
}
