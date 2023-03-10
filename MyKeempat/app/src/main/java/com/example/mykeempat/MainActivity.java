package com.example.mykeempat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
//    String x1[]={"adi","budi","cindi","didi","eli"};
//    String x2[]={"JKT","SBY","BDG","YGY","MAD"};
//    String x3[]={"081","082","083","084","085"};
//    int x4[]={R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5};
    ListView L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L=(ListView)findViewById(R.id.isi);
     //   ArrayAdapter<String>a = new ArrayAdapter<String>(this,R.layout.layoutlistview,R.id.textViewNama,x);
     //   L.setAdapter(a);
        final DataArray array = new DataArray();
        isiadapter xxx = new isiadapter(getApplicationContext(),array.x1,array.x2,array.x3,array.x4,array.x5,array.x6);
        L.setAdapter(xxx);
        L.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent lanjut = new Intent(getApplicationContext(), MainActivityKeterangan.class);
                lanjut.putExtra("Nama Hewan",array.x1[position]);
                lanjut.putExtra("Jenis Hewan",array.x2[position]);
                lanjut.putExtra("Habitat Hewan",array.x3[position]);
                lanjut.putExtra("Kelas Hewan",array.x4[position]);
                lanjut.putExtra("Keterangan Hewan",array.x5[position]);
                lanjut.putExtra("image",array.x6[position]);
                startActivity(lanjut);
            }

        });
    }
}