package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityMenu extends AppCompatActivity implements View.OnClickListener {

    private Button btnUser, btnWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnUser = findViewById(R.id.btnUser);
        btnUser.setOnClickListener(this);

        btnWisata = findViewById(R.id.btnWisata);
        btnWisata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnUser){
            Intent i_user = new Intent(MainActivityMenu.this, UserActivity.class);
            startActivity(i_user);

        } else if(v == btnWisata){
            Intent i_wisata = new Intent(MainActivityMenu.this, MainActivity.class);
            startActivity(i_wisata);
        }
    }
}