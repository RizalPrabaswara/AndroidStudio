package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainListView1 extends AppCompatActivity {
    ListView L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view1);
        L=(ListView)findViewById(R.id.ListIsi);

        final DataArrayList array = new DataArrayList();
        IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(), array.judul1, array.tahun1, array.icon1);
        L.setAdapter(xxx);


//        posisi.setText(getIntent().getStringExtra("Posisi"));
//            if(String.valueOf(posisi.getText()).equals("1")){
//                IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(),array.judul1,array.tahun1,array.icon);
//                L.setAdapter(xxx);
//            }
//            else if(String.valueOf(posisi.getText()).equals("2")) {
//                IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(),array.judul2,array.tahun2,array.icon);
//                L.setAdapter(xxx);
//            }
//            else if(String.valueOf(posisi.getText()).equals("3")) {
//                IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(),array.judul3,array.tahun3,array.icon);
//                L.setAdapter(xxx);
//            }
//            else if(String.valueOf(posisi.getText()).equals("4")) {
//                IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(),array.judul4,array.tahun4,array.icon);
//                L.setAdapter(xxx);
//            }
//            else if(String.valueOf(posisi.getText()).equals("5")) {
//                IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(),array.judul5,array.tahun5,array.icon);
//                L.setAdapter(xxx);
//            }
//            else{
//                IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(),array.judul6,array.tahun6,array.icon);
//                L.setAdapter(xxx);
//            }
        }
    }