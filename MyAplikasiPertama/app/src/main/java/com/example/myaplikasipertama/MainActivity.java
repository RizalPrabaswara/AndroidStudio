package com.example.myaplikasipertama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView hasil;
    EditText n1,n2;
    Button tambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasil=(TextView)findViewById(R.id.textViewhasil);
        n1=(EditText)findViewById(R.id.editTextNilai1);
        n2=(EditText)findViewById(R.id.editTextNilai2);
        tambah=(Button)findViewById(R.id.buttonTambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(n1.getText().toString());
                int b = Integer.parseInt(n2.getText().toString());
                int c = a+b;
                hasil.setText(String.valueOf(c));
            }
        });
    }
}