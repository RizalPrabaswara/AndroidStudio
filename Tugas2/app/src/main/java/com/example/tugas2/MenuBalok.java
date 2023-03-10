package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuBalok extends AppCompatActivity {

    private Button LP, Volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kubus);

        LP = (Button)findViewById(R.id.LuasPermukaan);
        LP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lpbalok = new Intent(getApplicationContext(), MenuLuasBalok.class);
                startActivity(lpbalok);
            }
        });

        Volume = (Button)findViewById(R.id.Volume);
        Volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volumebalok = new Intent(getApplicationContext(), MenuVolumeBalok.class);
                startActivity(volumebalok);
            }
        });
    }
}