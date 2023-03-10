package com.example.projectuts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {
    private Context c;
    private static final String DATABASE_NAME = "UTS";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "UTS18410100131";
    private static final String TABLE_NAME2 = "Profil";
    private static final String NAMA_GAME = "nama";
    private static final String GENRE_GAME = "genre";
    private static final String PLATFORM_GAME = "platform";
    private static final String TGL_RILIS = "tahun";
    private static final String HARGA_GAME = "harga";
    private static final String DESKRIPSI_GAME = "deskripsi";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE " + TABLE_NAME +
                " (" + NAMA_GAME + " VARCHAR PRIMARY KEY, " +
                GENRE_GAME + " VARCHAR, " +
                PLATFORM_GAME + " VARCHAR, " +
                TGL_RILIS + " VARCHAR, " +
                HARGA_GAME + " VARCHAR, " +
                DESKRIPSI_GAME + " VARCHAR);";
        db.execSQL(query1);
        db.execSQL("create table "+TABLE_NAME2+"(user varchar primary key, pass varchar, nama varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    void simpan(String nama, String genre, String platform, String tahun, String harga, String deskripsi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAMA_GAME,nama);
        cv.put(GENRE_GAME,genre);
        cv.put(PLATFORM_GAME,platform);
        cv.put(TGL_RILIS,tahun);
        cv.put(HARGA_GAME,harga);
        cv.put(DESKRIPSI_GAME,deskripsi);
        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(c, "Data Gagal Dimasukkan", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(c, "Data Berhasil Dimasukkan!", Toast.LENGTH_SHORT).show();
        }
    }

    void insert_user(String user, String pass, String nama){
        //untuk menulis data di database
        SQLiteDatabase db = this.getWritableDatabase();

        //deklarasi nama dan isi tabel
        ContentValues cv = new ContentValues();
        cv.put("user", user);
        cv.put("pass", pass);
        cv.put("nama", nama);
        //untuk create di database
        db.insert(TABLE_NAME2, null, cv);
    }

    void update(String nama, String genre, String platform, String tahun, String harga, String deskripsi){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(NAMA_GAME,nama);
        cv.put(GENRE_GAME,genre);
        cv.put(PLATFORM_GAME,platform);
        cv.put(TGL_RILIS,tahun);
        cv.put(HARGA_GAME,harga);
        cv.put(DESKRIPSI_GAME,deskripsi);
        long result = db.update(TABLE_NAME,cv,"nama=?", new String[]{(nama)});
        if(result == -1){
            Toast.makeText(c, "Data Gagal Diupdate", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(c, "Data Berhasil Diupdate!", Toast.LENGTH_SHORT).show();
        }
    }

    void delete(String nama){
        SQLiteDatabase db=this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,"nama=?", new String[]{(nama)});
        if(result == -1){
            Toast.makeText(c, "Data Gagal Dihapus", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(c, "Data Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor pilihsemua(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public Cursor cari(String query){
        //untuk membaca data di database
        SQLiteDatabase db = this.getReadableDatabase();

        //syntax select all
        Cursor c = db.rawQuery(query, null);
        return c;
    }
}
