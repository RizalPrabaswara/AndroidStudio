package com.example.mykeempat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityKeterangan extends AppCompatActivity {

    private Button kembali;
    private TextView nama,jenis,habitat,kelas,keterangan;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_keterangan);
        kembali = (Button)findViewById(R.id.buttonKembali);

        nama = (TextView)findViewById(R.id.textViewNama);
        jenis = (TextView)findViewById(R.id.textViewJenis);
        habitat = (TextView)findViewById(R.id.textViewHabitat);
        kelas = (TextView)findViewById(R.id.textViewKelas);
        keterangan = (TextView)findViewById(R.id.textViewKeterangan);
        foto = (ImageView) findViewById(R.id.imageViewFoto);

        nama.setText(getIntent().getStringExtra("Nama Hewan"));
        jenis.setText(getIntent().getStringExtra("Jenis Hewan"));
        habitat.setText(getIntent().getStringExtra("Habitat Hewan"));
        kelas.setText(getIntent().getStringExtra("Kelas Hewan"));
        keterangan.setText(getIntent().getStringExtra("Keterangan Hewan"));
        foto.setImageResource(Integer.parseInt(String.valueOf(getIntent().getIntExtra("image",0))));

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(kembali);
            }
        });

    }
}