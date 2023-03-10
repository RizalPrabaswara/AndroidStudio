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

public class MainSupplier1 extends AppCompatActivity implements AdapterSupplier.OnSupplierListener {
    APIService xApiservice;
    RecyclerView rec;
    private ArrayList<ListDataSupplier> datasupplier1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_supplier1);
        rec=(RecyclerView)findViewById(R.id.ListSupplier);

        xApiservice=ApiUtils.getAPIService();
        BacaData();

        FloatingActionButton fabsupplier = findViewById(R.id.fabsupplier);
        fabsupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formsupplier = new Intent(getApplicationContext(),formsupplier.class);
                startActivity(formsupplier);
            }
        });
    }
    public void BacaData(){
        xApiservice.AmbilDataSupplier().enqueue(new Callback<GetDataSupplier>() {
            @Override
            public void onResponse(Call<GetDataSupplier> call, Response<GetDataSupplier> response) {
                Log.d("Isi data",response.body().getData().toString());
                datasupplier1 = new ArrayList<>();
                for(int i=0;i<response.body().getData().size();i++)
                {
                    datasupplier1.add(new ListDataSupplier(response.body().getData().get(i).getIdsupplier(),response.body().getData().get(i).getNamasupplier(),response.body().getData().get(i).getNotelepon(),response.body().getData().get(i).getNamabarang(),response.body().getData().get(i).getImagesupplier()));
                }
                AdapterSupplier adaptersupplier = new AdapterSupplier(datasupplier1,getApplicationContext(),MainSupplier1.this::OnSupplierClick);
                RecyclerView.LayoutManager layoutmanager;
                layoutmanager = new LinearLayoutManager(getApplicationContext());
                rec.setLayoutManager(layoutmanager);
                rec.setAdapter(adaptersupplier);
                adaptersupplier.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetDataSupplier> call, Throwable t) {

            }
        });
    }

    @Override
    public void OnSupplierClick(int position) {
        datasupplier1.get(position);
        Intent formupdate = new Intent(getApplicationContext(),formupdatesupplier.class);
        startActivity(formupdate);
    }
}