package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    String nama[]={"C#","Laravel","Phython","PHP","Visual Studio","C++"};
    String keterangan[]={"Easy","Hard","Medium","Medium","Hard","Easy"};
    int foto[]={R.drawable.logo1,R.drawable.logo2,R.drawable.logo3,R.drawable.logo4,R.drawable.logo5,R.drawable.logo6};
    GridView g;
    ImageView bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g=(GridView)findViewById(R.id.GridIsi);
        bg=(ImageView)findViewById(R.id.GambarBackground);
        bg.setImageResource(R.drawable.bg);
        IsiAdapter isi = new IsiAdapter(getApplicationContext(),nama,keterangan,foto);
        g.setAdapter(isi);
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent lanjut = new Intent(getApplicationContext(), MainListView1.class);
                    startActivity(lanjut);
                }
                else if(position == 1){
                    Intent lanjut = new Intent(getApplicationContext(), MainListView2.class);
                    startActivity(lanjut);
                }
                else if(position == 2){
                    Intent lanjut = new Intent(getApplicationContext(), MainListView3.class);
                    startActivity(lanjut);
                }
                else if(position == 3){
                    Intent lanjut = new Intent(getApplicationContext(), MainListView4.class);
                    startActivity(lanjut);
                }
                else if(position == 4){
                    Intent lanjut = new Intent(getApplicationContext(), MainListView5.class);
                    startActivity(lanjut);
                }
                else{
                    Intent lanjut = new Intent(getApplicationContext(), MainListView6.class);
                    startActivity(lanjut);
                }
            }
        });
    }
}