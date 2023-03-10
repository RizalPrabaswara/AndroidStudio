package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    TextView h;
    EditText k,n,a;
    RecyclerView rec;
    APIService xApiservice;
    private ArrayList<ListDataUser> datauser1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h=(TextView)findViewById(R.id.textView);
        rec=(RecyclerView)findViewById(R.id.ListHasil);
        k=(EditText)findViewById(R.id.editTextKode);
        n=(EditText)findViewById(R.id.editTextNama);
        a=(EditText)findViewById(R.id.editTextAlamat);
        if(getIntent().getStringExtra("Kode")!=null){
            k.setText(getIntent().getStringExtra("Kode"));
            n.setText(getIntent().getStringExtra("Nama"));
            a.setText(getIntent().getStringExtra("Alamat"));
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
//                datauser1 = new ArrayList<>();
//                for(int i=0;i<response.body().getData().size();i++)
//                    {
//                        datauser1.add(new ListDataUser(response.body().getData().get(i).getKode(),response.body().getData().get(i).getNama(),response.body().getData().get(i).getAlamat()));
//                    }
//                AdapterUser adapteruser = new AdapterUser(datauser1,getApplicationContext());
//                RecyclerView.LayoutManager layoutmanager;
//                layoutmanager = new LinearLayoutManager(getApplicationContext());
//                rec.setLayoutManager(layoutmanager);
//                rec.setAdapter(adapteruser);
                String hasil="";
                h.setText(response.body().getData().toString());
                h.setText(response.body().getData().get(1).getNama());
                for(int i=0;i<response.body().getData().size();i++)
                {
                    hasil=hasil+"\n"+response.body().getData().get(i).getNama()+"\\"+response.body().getData().get(i).getKode()+"\\"+response.body().getData().get(i).getAlamat();
                }
                h.setText(hasil);
            }


            @Override
            public void onFailure(Call<GetData> call, Throwable t) {

            }
        });
    }
}