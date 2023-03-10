package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityCreate extends AppCompatActivity {

    //deklarasi variabel
    Button btn_create;
    EditText nama, tempat, kategori, rating, harga;
    Cursor c;
    DBHelper dbwisata;
    String namabaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        //deklarasi item
        btn_create = (Button)findViewById(R.id.btn_create);
        nama = (EditText)findViewById(R.id.tf_nama);
        tempat = (EditText)findViewById(R.id.tf_tempat);
        kategori = (EditText)findViewById(R.id.tf_kategori);
        rating = (EditText)findViewById(R.id.tf_rating);
        harga = (EditText)findViewById(R.id.tf_harga);

        //deklarasi database
        dbwisata = new DBHelper(this,"datawisata",null,1);

        //simpan data ke database
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbwisata.Create(
                        nama.getText().toString(),
                        tempat.getText().toString(),
                        kategori.getText().toString(),
                        rating.getText().toString(),
                        harga.getText().toString());
                Cursor c = dbwisata.Select();
                c.moveToFirst();
                while (c.isAfterLast()==false){
                    String nama1 = c.getString(c.getColumnIndex("nama"));
                    String tempat1 = c.getString(c.getColumnIndex("tempat"));
                    String kategori1 = c.getString(c.getColumnIndex("kategori"));
                    String rating1 = c.getString(c.getColumnIndex("rating"));
                    String harga1 = c.getString(c.getColumnIndex("harga"));
                    c.moveToNext();
                }
                Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(kembali);
            }
        });
    }
}