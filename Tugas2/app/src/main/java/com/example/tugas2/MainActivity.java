package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button kubus, balok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kubus = (Button)findViewById(R.id.Kubus);
        kubus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kubus = new Intent(getApplicationContext(), MenuKubus.class);
                startActivity(kubus);
            }
        });

        balok = (Button)findViewById(R.id.Balok);
        balok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balok = new Intent(getApplicationContext(), MenuBalok.class);
                startActivity(balok);
            }
        });
    }
}