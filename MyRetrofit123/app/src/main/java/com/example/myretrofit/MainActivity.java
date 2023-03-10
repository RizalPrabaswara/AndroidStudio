package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec;
    APIService xApiservice;
    EditText k,n,a;
    private ArrayList<ListDataProfil> dataprof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec =(RecyclerView)findViewById(R.id.isi);
        k=(EditText)findViewById(R.id.editTextKode) ;
        n=(EditText)findViewById(R.id.editTextNama) ;
        a=(EditText)findViewById(R.id.editTextAlamat) ;
        if(getIntent().getStringExtra("kode")!=null)
        {
            k.setText(getIntent().getStringExtra("kode"));
            n.setText(getIntent().getStringExtra("nama"));
            a.setText(getIntent().getStringExtra("alamat"));
        }


        xApiservice=ApiUtils.getAPIService();
        BacaData();

    }
    public void BacaData()
    {
        xApiservice.AmbilData().enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
               Log.d("Isi data",response.body().getData().toString());
               dataprof=new ArrayList<>();
               for(int i=0;i<response.body().getData().size();i++)
               {
                   dataprof.add(new ListDataProfil(response.body().getData().get(i).getKode(),response.body().getData().get(i).getNama(),response.body().getData().get(i).getAlamat()));
               }
               AdapterProfil adapterProfil = new AdapterProfil(dataprof,getApplicationContext());
               RecyclerView.LayoutManager layoutManager;
               layoutManager = new LinearLayoutManager(getApplicationContext());
               rec.setLayoutManager(layoutManager);
               rec.setAdapter(adapterProfil);
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
}