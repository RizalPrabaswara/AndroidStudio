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

public class formbarang extends AppCompatActivity {
    private static final String UPLOAD_URL = "http://192.168.100.7/androidretrofit/upload1.php";
    EditText ng,ketg,hg;
    TextView p;
    ImageView fb;
    Button td,pf;
    APIService xApiservice;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formbarang);

//        kg=(EditText)findViewById(R.id.editTextIDBarang);
        ng=(EditText)findViewById(R.id.editTextNamaGame);
        ketg=(EditText)findViewById(R.id.editTextKeterangan);
        hg=(EditText)findViewById(R.id.editTextHarga);
        p=(TextView)findViewById(R.id.textViewPath);
        fb=(ImageView)findViewById(R.id.imageViewBarangUpdate);
        td=(Button)findViewById(R.id.buttonTambahBarang);
        pf=(Button)findViewById(R.id.buttonFileBarangUpdate);
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
                //SimpanData(ng.getText().toString(),ketg.getText().toString(),hg.getText().toString());
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

    public void uploadMultipart(){
        String nama = ng.getText().toString().trim();
        String kelas = ketg.getText().toString().trim();
        String alamat = hg.getText().toString().trim();

        String path = getPath(x);
        try{
            String uploadid = "";
            new MultipartUploadRequest(this, uploadid, UPLOAD_URL)
                    .addFileToUpload(path, "image")
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

}

//    public void SimpanData(String ng,String ketg, String hg)
//    {
//        File f = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), System.currentTimeMillis() + "_image.jpg");
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        FileFoto.compress(Bitmap.CompressFormat.JPEG, 100, bos);
//        byte[] bitmapdata = bos.toByteArray();
//        try {
//            FileOutputStream fos = new FileOutputStream(f);
//            fos.write(bitmapdata);
//            fos.flush();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        RequestBody requestbody = RequestBody.create(MediaType.parse("text/plain"), "submit");
//        HashMap<String, RequestBody> map = new HashMap<>();
//        map.put("submit", requestbody);
//        RequestBody requestfile = RequestBody.create(MediaType.parse(getContentResolver().getType(fileuri)), f);
//        MultipartBody.Part body = MultipartBody.Part.createFormData("fileToUpload", f.getName(), requestfile);
//        xApiservice.SimpanData(ng,ketg,hg).enqueue(new Callback<GetDataFoto>() {
//            @Override
//            public void onResponse(Call<GetDataFoto> call, Response<GetDataFoto> response) {
//                Log.d("Save", "Sukses");
//            }
//
//            @Override
//            public void onFailure(Call<GetDataFoto> call, Throwable t) {
//
//            }
//        });
//    }