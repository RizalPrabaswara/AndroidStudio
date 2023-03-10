package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity1 extends AppCompatActivity {

    private DBHelper dbprofil;
    EditText u,p,n;
    private Button kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);

        u=(EditText) findViewById(R.id.username);
        p=(EditText) findViewById(R.id.password);
        n=(EditText) findViewById(R.id.nama);
        //dbprofil.insert_user("user1", "123", "adi");
        //dbprofil.insert_user("user2", "tugiman22", "rizal");
        //dbprofil.insert_user("user3", "260320", "Jenny");
        //dbprofil.insert_user("user4", "123456789", "Annisa");


        kembali=(Button)findViewById(R.id.Kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbprofil = new DBHelper(UserActivity1.this);
                dbprofil.insert_user(u.getText().toString(),p.getText().toString(),n.getText().toString());
                Intent kembali = new Intent(UserActivity1.this, LoginActivity.class);
                startActivity(kembali);
            }
        });
    }
}