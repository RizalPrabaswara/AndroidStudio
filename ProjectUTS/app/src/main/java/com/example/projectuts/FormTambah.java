package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class FormTambah extends AppCompatActivity {
    EditText ng,trg,hg,dg;
    Spinner gg;
    RadioButton k,p,n,m;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah);
        ng=(EditText)findViewById(R.id.namagame1);
        trg=(EditText)findViewById(R.id.tahunrilis1);
        hg=(EditText)findViewById(R.id.hargagame1);
        dg=(EditText)findViewById(R.id.deskripsigame1);
        gg=(Spinner)findViewById(R.id.GenreGame1);
        k=(RadioButton)findViewById(R.id.platform_komputer1);
        p=(RadioButton)findViewById(R.id.platform_playstation1);
        n=(RadioButton)findViewById(R.id.platform_nintendo1);
        m=(RadioButton)findViewById(R.id.platform_mobile1);
        simpan=(Button)findViewById(R.id.ButtonSimpan);

        final DBHelper databasehelper = new DBHelper(FormTambah.this);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k.isChecked()){
                    databasehelper.simpan(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            k.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
                else if(p.isChecked()){
                    databasehelper.simpan(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            p.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
                else if(n.isChecked()){
                    databasehelper.simpan(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            n.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
                else{
                    databasehelper.simpan(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            m.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
            }
        });
    }
}