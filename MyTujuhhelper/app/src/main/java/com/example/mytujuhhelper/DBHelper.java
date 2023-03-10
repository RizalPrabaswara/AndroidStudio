package com.example.mytujuhhelper;

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
        db.execSQL("create table profil(kode varchar primary key, nama varchar, alamat varchar);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS profil");
        onCreate(db);
    }

    public boolean Simpan(String kode, String nama, String alamat){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("kode",kode);
        cv.put("nama",nama);
        cv.put("alamat",alamat);
        db.insert("profil",null,cv);
        return true;
    }

    public boolean Update(String kode, String nama, String alamat){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("kode",kode);
        cv.put("nama",nama);
        cv.put("alamat",alamat);
        db.update("profil",cv,"kode=?", new String[]{(kode)});
        return true;
    }

    public boolean Delete(String kode){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("profil","kode=?", new String[]{(kode)});
        return true;
    }

    public Cursor pilihsemua(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor x = db.rawQuery("select * from profil",null);
        return x;
    }

    public Cursor pilihtertentu(String kode){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor x = db.rawQuery("select * from profil where kode ="+kode+"",null);
        return x;
    }
}
