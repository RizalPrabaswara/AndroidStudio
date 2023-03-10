package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityUpdateDelete extends AppCompatActivity {

    //deklarasi variabel
    String hasilnama, hasiltempat, hasilkategori, hasilrating, hasilharga;
    Button btn_update, btn_delete;
    EditText nama, tempat, kategori, rating, harga;
    Cursor c;
    DBHelper dbwisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updatedelete);

        //deklarasi item
        btn_update = (Button)findViewById(R.id.btn_update);
        btn_delete = (Button)findViewById(R.id.btn_delete);
        nama = (EditText)findViewById(R.id.tf_nama);
        tempat = (EditText)findViewById(R.id.tf_tempat);
        kategori = (EditText)findViewById(R.id.tf_kategori);
        rating = (EditText)findViewById(R.id.tf_rating);
        harga = (EditText)findViewById(R.id.tf_harga);

        //ambil hasil intent
        hasilnama = getIntent().getStringExtra("nama");
        hasiltempat = getIntent().getStringExtra("tempat");
        hasilkategori = getIntent().getStringExtra("kategori");
        hasilrating = getIntent().getStringExtra("rating");
        hasilharga = getIntent().getStringExtra("harga");

        //set hasil intent ke edittext
        nama.setText(hasilnama);
        tempat.setText(hasiltempat);
        kategori.setText(hasilkategori);
        rating.setText(hasilrating);
        harga.setText(hasilharga);

        //menghilangkan edittext nama
        nama.setEnabled(false);

        //deklarasi database
        dbwisata = new DBHelper(this,"datawisata",null,1);

        //update data ke database
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbwisata.Update(nama.getText().toString(), tempat.getText().toString(), kategori.getText().toString(), rating.getText().toString(), harga.getText().toString());
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

        //delete data dari database
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbwisata.Delete(nama.getText().toString());
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