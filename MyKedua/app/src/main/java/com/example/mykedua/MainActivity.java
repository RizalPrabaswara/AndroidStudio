package com.example.mykedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView n1,n2,hasil;
    Button t,k,x,b;
    Perhitungan p = new Perhitungan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1=(TextView)findViewById(R.id.editTextNumber1);
        n2=(TextView)findViewById(R.id.editTextNumber2);
        hasil=(TextView)findViewById(R.id.editTextNumberHasil);
        t=(Button)findViewById(R.id.buttonTambah);
        k=(Button)findViewById(R.id.buttonKurang);
        x=(Button)findViewById(R.id.buttonKali);
        b=(Button)findViewById(R.id.buttonBagi);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(n1.getText().toString());
                int b = Integer.parseInt(n2.getText().toString());
                int c = p.tambah(a,b);
                hasil.setText(String.valueOf(c));
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(n1.getText().toString());
                int b = Integer.parseInt(n2.getText().toString());
                int c = p.kurang(a,b);
                hasil.setText(String.valueOf(c));
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(n1.getText().toString());
                int b = Integer.parseInt(n2.getText().toString());
                double c = p.kali(a,b);
                hasil.setText(String.valueOf(c));
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(n1.getText().toString());
                int b = Integer.parseInt(n2.getText().toString());
                double c = p.bagi(a,b);;
                hasil.setText(String.valueOf(c));
            }
        });
    }
}