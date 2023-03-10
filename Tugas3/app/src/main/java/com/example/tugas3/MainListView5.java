package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainListView5 extends AppCompatActivity {
    ListView L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view5);
        L=(ListView)findViewById(R.id.ListIsi);

        final DataArrayList a = new DataArrayList();
        IsiAdapterList xxx = new IsiAdapterList(getApplicationContext(), a.judul5, a.tahun5, a.icon5);
        L.setAdapter(xxx);
    }
}