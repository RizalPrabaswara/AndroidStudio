package com.example.mytujuhhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText k,n,a;
    Button s,u,d;
    TextView h;
    DBHelper dbxx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        k=(EditText)findViewById(R.id.Kode);
        n=(EditText)findViewById(R.id.Nama);
        a=(EditText)findViewById(R.id.Alamat);
        s=(Button)findViewById(R.id.save);
        u=(Button)findViewById(R.id.Update);
        d=(Button)findViewById(R.id.Delete);
        h=(TextView)findViewById(R.id.Hasil);

        dbxx=new DBHelper(this,"dataku",null,1);
        Cursor x = dbxx.pilihsemua();
        String y="";
        x.moveToFirst();
        while(x.isAfterLast()==false){
            String kk=x.getString(x.getColumnIndex("kode"));
            String nn=x.getString(x.getColumnIndex("nama"));
            String aa=x.getString(x.getColumnIndex("alamat"));
            y=y+"   \\  "+kk+""+nn+""+aa;
            x.moveToNext();
        }
        h.setText(y);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbxx.Simpan(k.getText().toString(),n.getText().toString(),a.getText().toString());
                Cursor x = dbxx.pilihsemua();
                String y="";
                x.moveToFirst();
                while(x.isAfterLast()==false){
                    String kk=x.getString(x.getColumnIndex("kode"));
                    String nn=x.getString(x.getColumnIndex("nama"));
                    String aa=x.getString(x.getColumnIndex("alamat"));
                    y=y+"   \\  "+kk+""+nn+""+aa;
                    x.moveToNext();
                }
                h.setText(y);
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbxx.Update(k.getText().toString(),n.getText().toString(),a.getText().toString());
                Cursor x = dbxx.pilihsemua();
                String y="";
                x.moveToFirst();
                while(x.isAfterLast()==false){
                    String kk=x.getString(x.getColumnIndex("kode"));
                    String nn=x.getString(x.getColumnIndex("nama"));
                    String aa=x.getString(x.getColumnIndex("alamat"));
                    y=y+"   \\  "+kk+""+nn+""+aa;
                    x.moveToNext();
                }
                h.setText(y);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbxx.Delete(k.getText().toString());
                Cursor x = dbxx.pilihsemua();
                String y="";
                x.moveToFirst();
                while(x.isAfterLast()==false){
                    String kk=x.getString(x.getColumnIndex("kode"));
                    String nn=x.getString(x.getColumnIndex("nama"));
                    String aa=x.getString(x.getColumnIndex("alamat"));
                    y=y+"   \\  "+kk+""+nn+""+aa;
                    x.moveToNext();
                }
                h.setText(y);
            }
        });
    }
}