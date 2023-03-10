package com.example.mykelima;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IsiAdapter extends BaseAdapter {
    Context c;
    String judul[];
    String ket[];
    int foto[];
    LayoutInflater z;

    public IsiAdapter(Context c, String[] judul, String[] ket, int[] foto) {
        this.c = c;
        this.judul = judul;
        this.ket = ket;
        this.foto = foto;
        this.z = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return judul.length;
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
        convertView = z.inflate(R.layout.layoutisi, null);
        TextView j = (TextView)convertView.findViewById(R.id.textView1);
        TextView k = (TextView)convertView.findViewById(R.id.textView2);
        ImageView f = (ImageView)convertView.findViewById(R.id.imageView);
        j.setText(judul[position]);
        k.setText(ket[position]);
        f.setImageResource(foto[position]);
        return convertView;
    }
}
