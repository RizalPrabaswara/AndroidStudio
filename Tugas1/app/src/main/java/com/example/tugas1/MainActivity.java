package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tugas1.Perhitungan.Volume;

public class MainActivity extends AppCompatActivity {

    private EditText setpanjang, setlebar, settinggi, setsisi;
    private Button proses;
    private TextView LPKubus, LPBalok, VKubus, VBalok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setpanjang=findViewById(R.id.editTextPanjang);
        setlebar=findViewById(R.id.editTextLebar);
        settinggi=findViewById(R.id.editTextTinggi);
        setsisi=findViewById(R.id.editTextSisi);

        LPKubus = findViewById(R.id.textViewLuasPermukaanKubus);
        LPBalok = findViewById(R.id.textViewLuasPermukaanBalok);
        VKubus = findViewById(R.id.textViewVolumeKubus);
        VBalok = findViewById(R.id.textViewVolumeBalok);

        proses = findViewById(R.id.buttonProses);
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Volume o = new Volume();

                o.setPanjang(Double.parseDouble(setpanjang.getText().toString()));
                o.setLebar(Double.parseDouble(setlebar.getText().toString()));
                o.setTinggi(Double.parseDouble(settinggi.getText().toString()));
                o.setSisi(Double.parseDouble(setsisi.getText().toString()));

                LPKubus.setText(String.valueOf(o.getLuasPermukaanKubus()));
                LPBalok.setText(String.valueOf(o.getLuasPermukaanBalok()));
                VKubus.setText(String.valueOf(o.getVolumeKubus()));
                VBalok.setText(String.valueOf(o.getVolumeBalok()));
            }
        });
    }
}