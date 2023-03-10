package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugas2.Rumus.Volume;

public class HasilVolumeBalok extends AppCompatActivity implements View.OnClickListener{

    private TextView hasil;
    private Button kembali;

    private Volume rumus = new Volume();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_volume_balok);

        hasil = (TextView)findViewById(R.id.HasilVolumeBalok);
        kembali = (Button)findViewById(R.id.Kembali);

        double panjang = Double.parseDouble(getIntent().getStringExtra("PANJANG"));
        double lebar = Double.parseDouble(getIntent().getStringExtra("LEBAR"));
        double tinggi = Double.parseDouble(getIntent().getStringExtra("TINGGI"));
        rumus.setPanjang(panjang);
        rumus.setLebar(lebar);
        rumus.setTinggi(tinggi);
        hasil.setText("Luas Permukaan Balok : " + rumus.getVolumeBalok());

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