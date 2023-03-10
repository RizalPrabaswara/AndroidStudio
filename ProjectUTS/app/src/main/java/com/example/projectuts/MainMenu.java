package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    private Button Profil, Game;
    private TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        a=(TextView)findViewById(R.id.textView1);

//        Profil=(Button)findViewById(R.id.btnProfil);
//        Profil.setOnClickListener(this);
//
//        Game=(Button)findViewById(R.id.btnGame);
//        Game.setOnClickListener(this);

        SharedPreferences y = getSharedPreferences("UTS",MODE_PRIVATE);
        a.setText("Selamat Datang "+y.getString("user",null));
    }

    public void onClick(View v){
        if(v == Profil){
            Intent profil = new Intent(MainMenu.this, UserActivity1.class);
            startActivity(profil);

        } else if(v == Game){
            Intent game = new Intent(MainMenu.this, MainActivity.class);
            startActivity(game);
        }
    }
}