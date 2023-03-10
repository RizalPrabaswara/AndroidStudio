package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuVolumeKubus extends AppCompatActivity {

    private EditText SisiKubus;
    private Button hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_luas_kubus);

        SisiKubus = (EditText)findViewById(R.id.SisiKubus);
        hitung = (Button)findViewById(R.id.Hitung);
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hasilvolumekubus = new Intent(getApplicationContext(), HasilVolumeKubus.class);
                hasilvolumekubus.putExtra("SISI", SisiKubus.getText().toString());
                startActivity(hasilvolumekubus);
            }
        });
    }
}