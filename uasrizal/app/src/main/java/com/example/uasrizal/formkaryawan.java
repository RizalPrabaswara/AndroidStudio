package com.example.uasrizal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;

public class formkaryawan extends AppCompatActivity {
    private static final String UPLOAD_URL = "http://192.168.100.7/androidretrofit/upload3.php";
    EditText nk,j,g;
    TextView pk;
    ImageView fk;
    Button td,pf;
    APIService xApiservice;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formkaryawan);

        nk=(EditText)findViewById(R.id.editTextNamaKaryawan);
        j=(EditText)findViewById(R.id.editTextJabatan);
        g=(EditText)findViewById(R.id.editTextGaji);
        pk=(TextView)findViewById(R.id.textViewPathKaryawan);
        fk=(ImageView)findViewById(R.id.imageViewKaryawanUpdate);
        td=(Button)findViewById(R.id.buttonTambahKaryawan);
        pf=(Button)findViewById(R.id.buttonFileKaryawanUpdate);
        xApiservice = ApiUtils.getAPIService();

        pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(g,2);
            }
        });
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadMultipart();
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
                pk.setText(x.toString());
                fk.setImageBitmap(y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String idkaryawan = cursor.getString(0);
        idkaryawan = idkaryawan.substring(idkaryawan.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,
                MediaStore.Images.Media._ID+" = ? ",new String[]{idkaryawan}, null
        );
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    public void uploadMultipart(){
        String namakaryawan = nk.getText().toString().trim();
        String jabatan = j.getText().toString().trim();
        String gaji = g.getText().toString().trim();

        String path = getPath(x);
        try{
            String idkaryawan = "";
            new MultipartUploadRequest(this, idkaryawan, UPLOAD_URL)
                    .addFileToUpload(path, "image")
                    .addParameter("namakaryawan", namakaryawan)
                    .addParameter("jabatan", jabatan)
                    .addParameter("gaji", gaji)
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(3)
                    .startUpload();
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}