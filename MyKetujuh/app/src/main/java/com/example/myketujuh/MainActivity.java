package com.example.myketujuh;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText k,n,a;
    Button s,u,d;
    TextView h;
    private static String DBNAMA="dataku.db";
    Cursor c;

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
        final SQLiteDatabase db=openOrCreateDatabase(DBNAMA,MODE_PRIVATE,null);
        db.execSQL("create table if not exists profil(kode varchar, nama varchar, alamat varchar);");
        c=db.rawQuery("select * from profil",null);
        c.moveToFirst();
        String y="";
        while(c.isAfterLast()==false){
            String kk = c.getString(c.getColumnIndex("kode"));
            String nn = c.getString(c.getColumnIndex("nama"));
            String aa = c.getString(c.getColumnIndex("alamat"));
            y=y+"   \\  "+kk+""+nn+""+aa;
            c.moveToNext();
        }
        h.setText(y);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("insert into profil values('"+k.getText().toString()+"','"+n.getText().toString()+"',"+a.getText().toString()+"')");
                c=db.rawQuery("select * from profil",null);
                c.moveToFirst();
                String y="";
                while(c.isAfterLast()==false){
                    String kk = c.getString(c.getColumnIndex("kode"));
                    String nn = c.getString(c.getColumnIndex("nama"));
                    String aa = c.getString(c.getColumnIndex("alamat"));
                    y=y+"   \\  "+kk+""+nn+""+aa;
                    c.moveToNext();
                }
                h.setText(y);
            }
        });

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("update profil set nama='"+n.getText().toString()+"',alamat='"+a.getText().toString()+"' where kode ='"+k.getText().toString();"'");
                c=db.rawQuery("select * from profil",null);
                c.moveToFirst();
                String y="";
                while(c.isAfterLast()==false){
                    String kk = c.getString(c.getColumnIndex("kode"));
                    String nn = c.getString(c.getColumnIndex("nama"));
                    String aa = c.getString(c.getColumnIndex("alamat"));
                    y=y+"   \\  "+kk+""+nn+""+aa;
                    c.moveToNext();
                }
                h.setText(y);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}