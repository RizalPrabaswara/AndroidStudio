package com.example.myretrofitfix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView h;
    EditText k,n,a;
    RecyclerView rec;
    Button s,u,d,c;
    APIService xApiservice;
    private ArrayList<ListDataUser> datauser1;
//    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h=(TextView)findViewById(R.id.textView);
        rec=(RecyclerView)findViewById(R.id.ListHasil);
        k=(EditText)findViewById(R.id.editTextKode);
        n=(EditText)findViewById(R.id.editTextNama);
        a=(EditText)findViewById(R.id.editTextAlamat);
        s=(Button)findViewById(R.id.buttonSave);
        u=(Button)findViewById(R.id.buttonUpdate);
        c=(Button)findViewById(R.id.button4);
        d=(Button)findViewById(R.id.buttonDelete);
        if(getIntent().getStringExtra("Kode")!=null){
            k.setText(getIntent().getStringExtra("Kode"));
            n.setText(getIntent().getStringExtra("Nama"));
            a.setText(getIntent().getStringExtra("Alamat"));
        }
        xApiservice=ApiUtils.getAPIService();
        BacaData();
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpanData(k.getText().toString(),n.getText().toString(),a.getText().toString());
                Intent pindah =new Intent(getApplicationContext(),MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindah);
                //BacaData();
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UbahData(k.getText().toString(),n.getText().toString(),a.getText().toString());
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
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(),MainActivityUpload.class);
                startActivity(p);
            }
        });
    }
    public void BacaData()
    {
        xApiservice.AmbilData().enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
//                pd = new ProgressDialog(MainActivity.this);
//                pd.setMax(100);
//                pd.setMessage("Masih Proses");
//                pd.setTitle("Tuggu");
//                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                pd.show();
                Log.d("Isi data",response.body().getData().toString());
                datauser1 = new ArrayList<>();
                for(int i=0;i<response.body().getData().size();i++)
                    {
                        datauser1.add(new ListDataUser(response.body().getData().get(i).getKode(),response.body().getData().get(i).getNama(),response.body().getData().get(i).getAlamat()));
                    }
                AdapterUser adapteruser = new AdapterUser(datauser1,getApplicationContext());
                RecyclerView.LayoutManager layoutmanager;
                layoutmanager = new LinearLayoutManager(getApplicationContext());
                rec.setLayoutManager(layoutmanager);
                rec.setAdapter(adapteruser);
                adapteruser.notifyDataSetChanged();
//                pd.dismiss();
//                String hasil="";
//                h.setText(response.body().getData().toString());
//                h.setText(response.body().getData().get(1).getNama());
//                for(int i=0;i<response.body().getData().size();i++)
//                {
//                    hasil=hasil+"\n"+response.body().getData().get(i).getNama()+"\\"+response.body().getData().get(i).getKode()+"\\"+response.body().getData().get(i).getAlamat();
//                }
//                h.setText(hasil);
            }


            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
    public void SimpanData(String k,String n,String a)
    {
        xApiservice.SimpanData(k,n,a).enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                Log.d("Save", "Sukses");
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
    public void UbahData(String k,String n,String a)
    {
        xApiservice.UbahData(k,n,a).enqueue(new Callback<GetData>() {
            @Override
            public void onResponse(Call<GetData> call, Response<GetData> response) {
                Log.d("Update", "Sukses");
            }

            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
    public void HapusData(String k)
    {
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