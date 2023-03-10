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

public class MainBarang1 extends AppCompatActivity implements AdapterBarang.OnBarangListener {
    APIService xApiservice;
    RecyclerView rec;
    private ArrayList<ListDataBarang> databarang1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_barang1);

        rec=(RecyclerView)findViewById(R.id.ListBarang);

        xApiservice=ApiUtils.getAPIService();
        BacaData();

        FloatingActionButton fabbarang = findViewById(R.id.fabbarang);
        fabbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formbarang = new Intent(getApplicationContext(),formbarang.class);
                startActivity(formbarang);
            }
        });
    }
    public void BacaData(){
        xApiservice.AmbilData().enqueue(new Callback<GetDataBarang>() {
            @Override
            public void onResponse(Call<GetDataBarang> call, Response<GetDataBarang> response) {
                Log.d("Isi data",response.body().getData().toString());
                databarang1 = new ArrayList<>();
                for(int i=0;i<response.body().getData().size();i++)
                {
                    databarang1.add(new ListDataBarang(response.body().getData().get(i).getId(),
                            response.body().getData().get(i).getNama(),response.body().getData().get(i).getKelas(),response.body().getData().get(i).getAlamat(),response.body().getData().get(i).getImage()));
                }
                AdapterBarang adapterbarang = new AdapterBarang(databarang1,getApplicationContext(),MainBarang1.this::OnBarangClick);
                RecyclerView.LayoutManager layoutmanager;
                layoutmanager = new LinearLayoutManager(getApplicationContext());
                rec.setLayoutManager(layoutmanager);
                rec.setAdapter(adapterbarang);
                adapterbarang.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetDataBarang> call, Throwable t) {

            }
        });
    }

    @Override
    public void OnBarangClick(int position) {
        databarang1.get(position);
        Intent formupdate = new Intent(getApplicationContext(),formupdatebarang.class);
        startActivity(formupdate);
    }
}