package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IsiAdapter.RecyclerViewClickListener {
    RecyclerView menu;
    Button tambah;
    DBHelper adapterDB;
    ArrayList<String> ngm,ggm,pgm,trgm,hgm,dgm;
    IsiAdapter adapterisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu=(RecyclerView)findViewById(R.id.MenuRecycler);
        tambah=(Button)findViewById(R.id.buttonTambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formtambah = new Intent(getApplicationContext(), FormTambah.class);
                startActivity(formtambah);
            }
        });

        adapterDB = new DBHelper(MainActivity.this);
        ngm = new ArrayList<>();
        ggm = new ArrayList<>();
        pgm = new ArrayList<>();
        trgm = new ArrayList<>();
        hgm = new ArrayList<>();
        dgm = new ArrayList<>();

        Storedata();
        adapterisi = new IsiAdapter(this,ngm,ggm,pgm,trgm,hgm,dgm,this);
        RecyclerView.LayoutManager layoutmanager;
        layoutmanager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        menu.setLayoutManager(layoutmanager);
        menu.setAdapter(adapterisi);
    }

    void Storedata(){
        Cursor cursor = adapterDB.pilihsemua();
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"Tidak Ada Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {
                ngm.add(cursor.getString(0));
                ggm.add(cursor.getString(1));
                pgm.add(cursor.getString(2));
                trgm.add(cursor.getString(3));
                hgm.add(cursor.getString(4));
                dgm.add(cursor.getString(5));
            }
        }
    }

    @Override
    public void OnClick(int position) {
        Intent formedit = new Intent(getApplicationContext(), FormEditDelete.class);
        startActivity(formedit);
    }
}



















//formedit.putExtra("Data",ngm.get(position).toString());