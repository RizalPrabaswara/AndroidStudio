package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugas2.Rumus.Volume;

public class HasilLuasKubus extends AppCompatActivity implements View.OnClickListener{

    private TextView hasil;
    private Button kembali;

    private Volume rumus = new Volume();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_luas_kubus);

        hasil = (TextView)findViewById(R.id.HasilLPKubus);
        kembali = (Button)findViewById(R.id.Kembali);

        double sisi = Double.parseDouble(getIntent().getStringExtra("SISI"));
        rumus.setSisi(sisi);
        hasil.setText("Luas Permukaan Kubus : " + rumus.getLuasPermukaanKubus());

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(kembali);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == kembali){

        }
    }
}