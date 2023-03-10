package com.example.proyekuts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserActivity extends AppCompatActivity {

    private DBHelper dbwisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        dbwisata = new DBHelper(this,"datawisata",null,1);
        dbwisata.insert_user("U01", "123", "gerdy");
        dbwisata.insert_user("U02", "123", "anita");
    }
}