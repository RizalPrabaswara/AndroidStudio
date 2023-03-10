package com.example.mykelima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView Tampilgrid;
    String jdl[] = {"Java","Kotlin","Flutter","Swift","PHP","C++"};
    String kt[] = {"Easy","Medium","Easy","Hard","Medium","Expert"};
    int ft[] = {R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tampilgrid=(GridView)findViewById(R.id.isinya);
        IsiAdapter xxx = new IsiAdapter(getApplicationContext(),jdl,kt,ft);
        Tampilgrid.setAdapter(xxx);
    }
}