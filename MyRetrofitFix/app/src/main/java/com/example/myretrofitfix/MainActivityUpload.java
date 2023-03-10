package com.example.myretrofitfix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityUpload extends AppCompatActivity {
    ImageView im;
    EditText c;
    Button of,oc,up;
    APIService xApiservice;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_upload);
        im=(ImageView)findViewById(R.id.imageViewFoto);
        of=(Button)findViewById(R.id.button);
        oc=(Button)findViewById(R.id.button3);
        up=(Button)findViewById(R.id.button2);
        xApiservice = ApiUtils.getAPIService();
        of.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(g,2);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadFoto(x,y);
                Intent g = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(g);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            x = data.getData();
            try {
                y = MediaStore.Images.Media.getBitmap(getContentResolver(),x);
                im.setImageBitmap(y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void UploadFoto(Uri fileuri,Bitmap FileFoto){
        EditText caption = (EditText)findViewById(R.id.editTextCaption);
        String c=caption.getText().toString().trim();
        File f = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),System.currentTimeMillis()+"_image.jpg");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileFoto.compress(Bitmap.CompressFormat.JPEG,100,bos);
        byte[] bitmapdata = bos.toByteArray();
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestBody requestbody = RequestBody.create(MediaType.parse("text/plain"),"submit");
        HashMap<String,RequestBody> map = new HashMap<>();
        map.put("submit",requestbody);
        RequestBody requestfile = RequestBody.create(MediaType.parse(getContentResolver().getType(fileuri)),f);
        MultipartBody.Part body = MultipartBody.Part.createFormData("fileToUpload",f.getName(),requestfile);

        xApiservice.UploadFoto(body,map,c).enqueue(new Callback<GetDataFoto>() {
            @Override
            public void onResponse(Call<GetDataFoto> call, Response<GetDataFoto> response) {
                Log.d("Foto","Sukses");
            }

            @Override
            public void onFailure(Call<GetDataFoto> call, Throwable t) {

            }
        });
    }

}