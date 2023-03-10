package com.example.mykeempat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class isiadapter extends BaseAdapter {
    Context c;
    String nama[],jenis[],habitat[],kelas[],keterangan[];
    int foto[];
    LayoutInflater z;

    public isiadapter(Context c, String[] nama, String[] jenis, String[] habitat, String[] kelas, String[] keterangan, int[] foto) {
        this.c = c;
        this.nama = nama;
        this.jenis = jenis;
        this.habitat = habitat;
        this.kelas = kelas;
        this.keterangan = keterangan;
        this.foto = foto;
        this.z = (LayoutInflater.from(c));
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
        convertView = z.inflate(R.layout.layoutlistview, null);
        TextView nama1 = (TextView) convertView.findViewById(R.id.textViewNama);
        TextView jenis1 = (TextView) convertView.findViewById(R.id.textViewJenis);
        TextView habitat1 = (TextView) convertView.findViewById(R.id.textViewHabitat);
        TextView kelas1 = (TextView) convertView.findViewById(R.id.textViewKelas);
        TextView keterangan1 = (TextView) convertView.findViewById(R.id.textViewKeterangan);
        ImageView foto1 = (ImageView) convertView.findViewById(R.id.imageViewFoto);
        nama1.setText(nama[position]);
        jenis1.setText(jenis[position]);
        habitat1.setText(habitat[position]);
        kelas1.setText(kelas[position]);
        keterangan1.setText(keterangan[position]);
        foto1.setImageResource(foto[position]);

        return convertView;
    }
}
