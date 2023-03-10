package com.example.uasrizal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class formupdatebarang extends AppCompatActivity {
    private static final String UPLOAD_URL = "http://192.168.100.7/androidretrofit/updatebarang.php";
    EditText ng,ketg,hg,kg;
    TextView p;
    ImageView fb;
    Button ud,pf,dd;
    APIService xApiservice;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formupdatebarang);

        kg=(EditText)findViewById(R.id.editTextIDBarangUpdate);
        ng=(EditText)findViewById(R.id.editTextNamaGameUpdate);
        ketg=(EditText)findViewById(R.id.editTextKeteranganUpdate);
        hg=(EditText)findViewById(R.id.editTextHargaUpdate);
        p=(TextView)findViewById(R.id.textViewPathUpdate);
        fb=(ImageView)findViewById(R.id.imageViewBarangUpdate);
        ud=(Button)findViewById(R.id.buttonUpdateBarang);
        dd=(Button)findViewById(R.id.buttonDeleteBarang);
        pf=(Button)findViewById(R.id.buttonFileBarangUpdate);
        xApiservice = ApiUtils.getAPIService();
        pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(g,2);
            }
        });
        ud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadMultipart();
                Intent pindah =new Intent(getApplicationContext(),MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindah);
            }
        });
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HapusData(kg.getText().toString());
                Intent pindah =new Intent(getApplicationContext(),MainActivity.class);
                pindah.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(pindah);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            x = data.getData();
            try {
                y = MediaStore.Images.Media.getBitmap(getContentResolver(),x);
                p.setText(x.toString());
                fb.setImageBitmap(y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String id = cursor.getString(0);
        id = id.substring(id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,
                MediaStore.Images.Media._ID+" = ? ",new String[]{id}, null
        );
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    private void uploadMultipart() {
        String nama = ng.getText().toString().trim();
        String kelas = ketg.getText().toString().trim();
        String alamat = hg.getText().toString().trim();
        String uploadid = kg.getText().toString().trim();

        String path = getPath(x);
        try{
            new MultipartUploadRequest(this, UPLOAD_URL)
                    .addFileToUpload(path, "image")
                    .addParameter("kode", uploadid)
                    .addParameter("nama", nama)
                    .addParameter("kelas", kelas)
                    .addParameter("alamat", alamat)
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(3)
                    .startUpload();
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void HapusData(String k){
        xApiservice.HapusData(k).enqueue(new Callback<GetDataBarang>() {
            @Override
            public void onResponse(Call<GetDataBarang> call, Response<GetDataBarang> response) {
                Log.d("Delete", "Sukses");
            }

            @Override
            public void onFailure(Call<GetDataBarang> call, Throwable t) {

            }
        });
    }
}