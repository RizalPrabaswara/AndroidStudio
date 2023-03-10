package com.example.myketiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView hasil;
    Button kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        hasil = (TextView)findViewById(R.id.hasil);
        kembali = (Button)findViewById(R.id.kembali);

        Intent terimo = getIntent();
        hasil.setText(terimo.getStringExtra("nilai1"));

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mbalik = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(mbalik);
            }
        });
    }
}