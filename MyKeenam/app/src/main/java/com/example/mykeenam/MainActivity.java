package com.example.mykeenam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Listisi> listdataisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.isi);
        listdataisi = new ArrayList<>();
        listdataisi.add(new Listisi("Agus","SBY","081",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Budi","JKT","093",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Cindy","SBY","012",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Agus","SBY","081",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Budi","JKT","093",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Cindy","SBY","012",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Agus","SBY","081",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Budi","JKT","093",R.drawable.ic_launcher_background));
        listdataisi.add(new Listisi("Cindy","SBY","012",R.drawable.ic_launcher_background));

        AdapterIsi adapter = new AdapterIsi(listdataisi);
        RecyclerView.LayoutManager layoutmanager;
        layoutmanager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setAdapter(adapter);
    }
}