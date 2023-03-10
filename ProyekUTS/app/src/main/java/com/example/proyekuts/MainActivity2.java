package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;
    EditText tf_username, tf_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tf_password = findViewById(R.id.tf_password);
        tf_username = findViewById(R.id.tf_username);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_login){
            // cek login dari database
            // cek user dan pass word  tidak boleh kosong
            if(tf_username.getText().toString().length() < 1){
                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }else if(tf_password.getText().toString().length() < 1){

            }else{
                DBHelper dbwisata = new DBHelper(this,"datawisata",null,1);

                int jml_data = 0;
                Cursor c = dbwisata.cari("select user from user where user = '" + tf_username.getText().toString() + "';");
                while (c.moveToNext()){
                    String temp = c.getString(c.getColumnIndex("user"));
                    jml_data++;
                }

                if(jml_data > 0){
                    // masukkan ke session
                    
                    Intent i_menu = new Intent(MainActivity2.this, MainActivityMenu.class);
                    startActivity(i_menu);
                }else{
                    Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}