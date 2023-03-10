package com.example.mykedelapan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText u,p;
Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u=(EditText)findViewById(R.id.editTextUsername);
        u=(EditText)findViewById(R.id.editTextUsername);
        b=(Button)findViewById(R.id.button);
        final SharedPreferences x = getSharedPreferences("dataku",MODE_PRIVATE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor ubah = x.edit();
                ubah.putString("usern",u.getText().toString());
                ubah.putString("pass",p.getText().toString());
                ubah.apply();
                Intent pindah = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(pindah);
            }
        });
    }
}