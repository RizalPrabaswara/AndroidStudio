package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuLuasBalok extends AppCompatActivity {

    private EditText panjang, lebar, tinggi;
    private Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_luas_balok);

        panjang = (EditText)findViewById(R.id.Panjang);
        lebar = (EditText)findViewById(R.id.Lebar);
        tinggi = (EditText)findViewById(R.id.Tinggi);
        hitung = (Button)findViewById(R.id.Hitung);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hasillpbalok = new Intent(getApplicationContext(), HasilLuasBalok.class);
                hasillpbalok.putExtra("PANJANG", panjang.getText().toString());
                hasillpbalok.putExtra("LEBAR", lebar.getText().toString());
                hasillpbalok.putExtra("TINGGI", tinggi.getText().toString());
                startActivity(hasillpbalok);
            }
        });
    }
}