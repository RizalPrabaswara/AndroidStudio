package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainListView2 extends AppCompatActivity {
    ListView L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view2);
        L=(ListView)findViewById(R.id.ListIsi);

        final DataArrayList a = new DataArrayList();
        IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(), a.judul2, a.tahun2, a.icon2);
        L.setAdapter(xxx);
    }
}