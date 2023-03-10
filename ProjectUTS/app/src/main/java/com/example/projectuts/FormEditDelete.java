package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class FormEditDelete extends AppCompatActivity {
    EditText ng,trg,hg,dg;
    Spinner gg;
    RadioButton k,p,n,m;
    Button update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit_delete);

        ng=(EditText)findViewById(R.id.namagame2);
        trg=(EditText)findViewById(R.id.tahunrilis2);
        hg=(EditText)findViewById(R.id.hargagame2);
        dg=(EditText)findViewById(R.id.deskripsigame2);
        gg=(Spinner)findViewById(R.id.GenreGame2);
        k=(RadioButton)findViewById(R.id.platform_komputer2);
        p=(RadioButton)findViewById(R.id.platform_playstation2);
        n=(RadioButton)findViewById(R.id.platform_nintendo2);
        m=(RadioButton)findViewById(R.id.platform_mobile2);
        update=(Button)findViewById(R.id.ButtonUpdate);
        delete=(Button)findViewById(R.id.ButtonDelete);
        //ng.setText(getIntent().getStringExtra("Data"));

        final DBHelper databasehelper1 = new DBHelper(FormEditDelete.this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(k.isChecked()){
                    databasehelper1.update(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            m.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
                else if(p.isChecked()){
                    databasehelper1.update(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            m.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
                else if(n.isChecked()){
                    databasehelper1.update(ng.getText().toString().trim(),
                            gg.getSelectedItem().toString().trim(),
                            m.getText().toString().trim(),
                            trg.getText().toString().trim(),
                            hg.getText().toString().trim(),
                            dg.getText().toString().trim());
                    Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(kembali);
                }
                else{
                    databasehelper1.update(ng.getText().toString().trim(),
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
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databasehelper1.delete(ng.getText().toString().trim());
                Intent kembali = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(kembali);
            }
        });
    }
}