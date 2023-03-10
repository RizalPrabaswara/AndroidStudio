package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.RecycleViewClickListener {

    //deklarasi variabel
    Button btn_add;
    RecyclerView recyclerView;
    DBHelper dbwisata;
    ArrayList<String> namarv, tempatrv, kategorirv, ratingrv, hargarv, namabarurv;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //deklarasi item
        btn_add = (Button)findViewById(R.id.btn_add);
        recyclerView= (RecyclerView)findViewById(R.id.listmenu);

        //deklarasi db + array list
        dbwisata = new DBHelper(this, "datawisata", null, 1);
        namarv = new ArrayList<>();
        tempatrv = new ArrayList<>();
        kategorirv = new ArrayList<>();
        ratingrv = new ArrayList<>();
        hargarv = new ArrayList<>();
        namabarurv = new ArrayList<>();

        //fetch data ke cursor
        Cursor c = dbwisata.Select();
        while (c.moveToNext()){
            namarv.add(c.getString(c.getColumnIndex("nama")));
            tempatrv.add(c.getString(c.getColumnIndex("tempat")));
            kategorirv.add(c.getString(c.getColumnIndex("kategori")));
            ratingrv.add(c.getString(c.getColumnIndex("rating")));
            hargarv.add(c.getString(c.getColumnIndex("harga")));
        }

        //fungsi recycle view
        adapter = new Adapter(this, namarv,tempatrv, kategorirv, ratingrv, hargarv, this);
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //pindah ke halaman create
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tambah = new Intent(getApplicationContext(), MainActivityCreate.class);
                startActivity(tambah);
            }
        });
    }

    //pindah ke halaman editdelete
    @Override
    public void Onclick(int position) {
        Intent edit = new Intent(this,MainActivityUpdateDelete.class);
        edit.putExtra("nama", namarv.get(position));
        edit.putExtra("tempat", tempatrv.get(position));
        edit.putExtra("kategori", kategorirv.get(position));
        edit.putExtra("rating", ratingrv.get(position));
        edit.putExtra("harga", hargarv.get(position));
        startActivity(edit);
    }
}