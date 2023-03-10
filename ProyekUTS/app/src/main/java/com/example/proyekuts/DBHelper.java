package com.example.proyekuts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //syntax buat database
        db.execSQL("create table wisata(nama varchar primary key, tempat varchar, kategori varchar, rating varchar, harga varchar)");
        db.execSQL("create table user(user varchar primary key, pass varchar, nama varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //syntax hapus database
        db.execSQL("drop table if exists wisata");
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    public boolean Create(String nama, String tempat, String kategori, String rating, String harga){
        //untuk menulis data di database
        SQLiteDatabase db = this.getWritableDatabase();

        //deklarasi nama dan isi tabel
        ContentValues cv = new ContentValues();
        cv.put("nama", nama);
        cv.put("tempat", tempat);
        cv.put("kategori", kategori);
        cv.put("rating", rating);
        cv.put("harga", harga);

        //untuk create di database
        db.insert("wisata", null, cv);
        return true;
    }

    public boolean insert_user(String user, String pass, String nama){
        //untuk menulis data di database
        SQLiteDatabase db = this.getWritableDatabase();

        //deklarasi nama dan isi tabel
        ContentValues cv = new ContentValues();
        cv.put("user", user);
        cv.put("pass", pass);
        cv.put("nama", nama);
        //untuk create di database
        db.insert("user", null, cv);
        return true;
    }

    public boolean Update(String nama, String tempat, String kategori, String rating, String harga){
        //untuk menulis data di database
        SQLiteDatabase db = this.getWritableDatabase();

        //deklarasi nama dan isi tabel
        ContentValues cv = new ContentValues();
        cv.put("nama", nama);
        cv.put("tempat", tempat);
        cv.put("kategori", kategori);
        cv.put("rating", rating);
        cv.put("harga", harga);

        //untuk update di database
        db.update("wisata", cv, "nama=?", new String[]{(nama)});
        return true;
    }

    public boolean Delete(String nama){
        //untuk menulis data di database
        SQLiteDatabase db = this.getWritableDatabase();

        //untuk delete di database
        db.delete("wisata", "nama=?", new String[]{(nama)});
        return true;
    }

    public Cursor Select(){
        //untuk membaca data di database
        SQLiteDatabase db = this.getReadableDatabase();

        //syntax select all
        Cursor c = db.rawQuery("select (nama || ' ' || harga) as nama, tempat, kategori, rating, harga from wisata", null);
        return c;
    }

    public Cursor cari(String query){
        //untuk membaca data di database
        SQLiteDatabase db = this.getReadableDatabase();

        //syntax select all
        Cursor c = db.rawQuery(query, null);
        return c;
    }
}
