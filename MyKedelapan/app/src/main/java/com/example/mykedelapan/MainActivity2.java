package com.example.mykedelapan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a=(TextView)findViewById(R.id.textView);
        b=(TextView)findViewById(R.id.textView2);
        SharedPreferences y = getSharedPreferences("dataku",MODE_PRIVATE);
        a.setText(y.getString("usern",null));
        a.setText(y.getString("pass",null));
    }
}