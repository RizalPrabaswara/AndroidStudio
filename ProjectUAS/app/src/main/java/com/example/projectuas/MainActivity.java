package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText k,n,g,p,h,t;
    RecyclerView rec;
    Button s,u,d;
    APIService xApiservice;
    private ArrayList<ListDataUAS> datauser1;
//    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=(RecyclerView)findViewById(R.id.layoutisi);
        k=(EditText)findViewById(R.id.editTextKode);
        n=(EditText)findViewById(R.id.editTextNama);
        g=(EditText)findViewById(R.id.editTextGenre);
        p=(EditText)findViewById(R.id.editTextPlatform);
        h=(EditText)findViewById(R.id.editTextHarga);
        t=(EditText)findViewById(R.id.editTextTahun);
        s=(Button)findViewById(R.id.buttonInsert);
        u=(Button)findViewById(R.id.buttonUpdate);
        d=(Button)findViewById(R.id.buttonDelete);
        xApiservice=ApiUtils.getAPIService();
        BacaData();

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpanData(k.getText().toString(),n.getText().toString(),g.getText().toString(),p.getText().toString(),h.getText().toString(),t.getText().toString());
                Intent pindah =new Intent(getApplicationContext(),MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindah);
                //BacaData();
            }
        });

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UbahData(k.getText().toString(),n.getText().toString(),g.getText().toString(),p.getText().toString(),h.getText().toString(),t.getText().toString());
                Intent pindah =new Intent(getApplicationContext(),MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindah);
                //BacaData();
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HapusData(k.getText().toString());
                Intent pindah =new Intent(getApplicationContext(),MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindah);
                //BacaData();
            }
        });
    }
    public  void BacaData(){
        xApiservice.AmbilData().enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                //pd = new ProgressDialog(MainActivity.this);
//                pd.setMax(100);
//                pd.setMessage("Masih Proses");
//                pd.setTitle("Tuggu");
//                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                pd.show();
                Log.d("Isi data",response.body().getData().toString());
                datauser1 = new ArrayList<>();
                for(int i=0;i<response.body().getData().size();i++)
                {
                    datauser1.add(new ListDataUAS(response.body().getData().get(i).getKode(),response.body().getData().get(i).getNama(),response.body().getData().get(i).getGenre(),response.body().getData().get(i).getPlatform(),response.body().getData().get(i).getHarga(),response.body().getData().get(i).getTahun()));
                }
                AdapterUAS adapteruser = new AdapterUAS(datauser1,getApplicationContext());
                RecyclerView.LayoutManager layoutmanager;
                layoutmanager = new LinearLayoutManager(getApplicationContext());
                rec.setLayoutManager(layoutmanager);
                rec.setAdapter(adapteruser);
                adapteruser.notifyDataSetChanged();
//                pd.dismiss();
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
    public void SimpanData(String k,String n,String g,String p,String h,String t){
        xApiservice.SimpanData(k,n,g,p,h,t).enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                Log.d("Save", "Sukses");
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
    public void UbahData(String k,String n,String g,String p,String h,String t){
        xApiservice.UbahData(k,n,g,p,h,t).enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                Log.d("Update", "Sukses");
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
    public void HapusData(String k){
        xApiservice.HapusData(k).enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                Log.d("Delete", "Sukses");
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
}