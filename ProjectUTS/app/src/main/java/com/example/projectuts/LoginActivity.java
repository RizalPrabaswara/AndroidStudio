package com.example.projectuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button login,daftar;
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pass = findViewById(R.id.tf_password);
        user = findViewById(R.id.tf_username);
        daftar = findViewById(R.id.btn_daftar);
        login = findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar1 = new Intent(LoginActivity.this, UserActivity1.class);
                startActivity(daftar1);
            }
        });
    }

    public void onClick (View v){
        if(v == login){
            // cek login dari database
            // cek user dan pass word  tidak boleh kosong
            if(user.getText().toString().length() < 1){
                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(pass.getText().toString().length() < 1){

            }else{
                DBHelper dbprofil = new DBHelper(this);

                int jml_data = 0;
                Cursor c = dbprofil.cari("select user from Profil where user = '" + user.getText().toString() + "';");
                while (c.moveToNext()){
                    String temp = c.getString(c.getColumnIndex("user"));
                    Log.d("AAA",temp);
                    jml_data++;
                }

                if(jml_data > 0){
                    // masukkan ke session
                    Intent i_menu = new Intent(LoginActivity.this, MainMenu.class);
                    SharedPreferences x  = getSharedPreferences("UTS",MODE_PRIVATE);
                    SharedPreferences.Editor ubah = x.edit();
                    ubah.putString("user",user.getText().toString());
                    ubah.apply();
                    startActivity(i_menu);
                }else{
                    Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}