package com.example.uasrizal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainKaryawan1 extends AppCompatActivity implements AdapterKaryawan.OnKaryawanListener {
    APIService xApiservice;
    RecyclerView rec;
    private ArrayList<ListDataKaryawan> datakaryawan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_karyawan1);
        rec=(RecyclerView)findViewById(R.id.ListKaryawan);

        xApiservice=ApiUtils.getAPIService();
        BacaData();

        FloatingActionButton fabkaryawan = findViewById(R.id.fabkaryawan);
        fabkaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formkaryawan = new Intent(getApplicationContext(),formkaryawan.class);
                startActivity(formkaryawan);
            }
        });
    }
    public void BacaData(){
        xApiservice.AmbilDataKaryawan().enqueue(new Callback<GetDataKaryawan>() {
            @Override
            public void onResponse(Call<GetDataKaryawan> call, Response<GetDataKaryawan> response) {
                Log.d("Isi data",response.body().getData().toString());
                datakaryawan1 = new ArrayList<>();
                for(int i=0;i<response.body().getData().size();i++)
                {
                    datakaryawan1.add(new ListDataKaryawan(response.body().getData().get(i).getIdkaryawan(),response.body().getData().get(i).getNamakaryawan(),response.body().getData().get(i).getJabatan(),response.body().getData().get(i).getGaji(),response.body().getData().get(i).getImagekaryawan()));
                }
                AdapterKaryawan adapterkaryawan = new AdapterKaryawan(datakaryawan1,getApplicationContext(),MainKaryawan1.this::OnKaryawanClick);
                RecyclerView.LayoutManager layoutmanager;
                layoutmanager = new LinearLayoutManager(getApplicationContext());
                rec.setLayoutManager(layoutmanager);
                rec.setAdapter(adapterkaryawan);
                adapterkaryawan.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetDataKaryawan> call, Throwable t) {

            }
        });
    }

    @Override
    public void OnKaryawanClick(int position) {
        datakaryawan1.get(position);
        Intent formupdate = new Intent(getApplicationContext(),formupdatekaryawan.class);
        startActivity(formupdate);
    }
}