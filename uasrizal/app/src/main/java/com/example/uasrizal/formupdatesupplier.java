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

public class formupdatesupplier extends AppCompatActivity {
    private static final String UPLOAD_URL = "http://192.168.100.7/androidretrofit/updatesupplier.php";
    EditText ns,nt,nb,ks;
    TextView ps;
    ImageView fs;
    Button ud,pf,dd;
    APIService xApiservice;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formupdatesupplier);

        ks=(EditText)findViewById(R.id.editTextIDSupplierUpdate);
        ns=(EditText)findViewById(R.id.editTextNamaSupplierUpdate);
        nt=(EditText)findViewById(R.id.editTextNoTeleponUpdate);
        nb=(EditText)findViewById(R.id.editTextNamaBarangUpdate);
        ps=(TextView)findViewById(R.id.textViewPathUpdateSupplier);
        fs=(ImageView)findViewById(R.id.imageViewSupplierUpdate);
        ud=(Button)findViewById(R.id.buttonUpdateSupplier);
        dd=(Button)findViewById(R.id.buttonDeleteSupplier);
        pf=(Button)findViewById(R.id.buttonFileSupplierUpdate);
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
                HapusDataSupplier(ks.getText().toString());
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
                ps.setText(x.toString());
                fs.setImageBitmap(y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String idsupplier = cursor.getString(0);
        idsupplier = idsupplier.substring(idsupplier.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,
                MediaStore.Images.Media._ID+" = ? ",new String[]{idsupplier}, null
        );
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    private void uploadMultipart() {
        String namasupplier = ns.getText().toString().trim();
        String notelepon = nt.getText().toString().trim();
        String namabarang = nb.getText().toString().trim();
        String idsupplier = ks.getText().toString().trim();

        String path = getPath(x);
        try{
            new MultipartUploadRequest(this, UPLOAD_URL)
                    .addFileToUpload(path, "image")
                    .addParameter("kodesupplier", idsupplier)
                    .addParameter("namasupplier", namasupplier)
                    .addParameter("notelepon", notelepon)
                    .addParameter("namabarang", namabarang)
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(3)
                    .startUpload();
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void HapusDataSupplier(String k){
        xApiservice.HapusDataSupplier(k).enqueue(new Callback<GetDataSupplier>() {
            @Override
            public void onResponse(Call<GetDataSupplier> call, Response<GetDataSupplier> response) {
                Log.d("Delete", "Sukses");
            }

            @Override
            public void onFailure(Call<GetDataSupplier> call, Throwable t) {

            }
        });
    }
}