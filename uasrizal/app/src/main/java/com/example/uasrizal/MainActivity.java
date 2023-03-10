package com.example.uasrizal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button b,s,k;
    RecyclerView background;
    private ArrayList<Listbackground> listdatabackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.buttonBarang);
        s = (Button)findViewById(R.id.buttonSupplier);
        k = (Button)findViewById(R.id.buttonKaryawan);
        background = (RecyclerView)findViewById(R.id.listbackground);
        listdatabackground = new ArrayList<>();
        listdatabackground.add(new Listbackground(R.drawable.logo4));
        listdatabackground.add(new Listbackground(R.drawable.logo1));
        listdatabackground.add(new Listbackground(R.drawable.logo2));
        listdatabackground.add(new Listbackground(R.drawable.logo3));
        listdatabackground.add(new Listbackground(R.drawable.logo5));

        AdapterBackground adapterbackground = new AdapterBackground(listdatabackground);
        RecyclerView.LayoutManager layoutmanagerbackground;
        layoutmanagerbackground = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        background.setLayoutManager(layoutmanagerbackground);
        background.setAdapter(adapterbackground);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lanjutbarang = new Intent(getApplicationContext(),MainBarang1.class);
                startActivity(lanjutbarang);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lanjutsupplier = new Intent(getApplicationContext(),MainSupplier1.class);
                startActivity(lanjutsupplier);
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lanjutkaryawan = new Intent(getApplicationContext(),MainKaryawan1.class);
                startActivity(lanjutkaryawan);
            }
        });
    }
}