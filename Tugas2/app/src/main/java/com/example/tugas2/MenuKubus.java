package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuKubus extends AppCompatActivity {

    private Button LP, Volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kubus);

        LP = (Button)findViewById(R.id.LuasPermukaan);
        LP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lpkubus = new Intent(getApplicationContext(), MenuLuasKubus.class);
                startActivity(lpkubus);
            }
        });

        Volume = (Button)findViewById(R.id.Volume);
        Volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volkubus = new Intent(getApplicationContext(), MenuVolumeKubus.class);
                startActivity(volkubus);
            }
        });
    }
}