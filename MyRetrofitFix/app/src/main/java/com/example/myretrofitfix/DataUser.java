package com.example.myretrofitfix;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUser {
    @SerializedName("Kode")
    @Expose
    private String kode;
    @SerializedName("Nama")
    @Expose
    private String nama;
    @SerializedName("Alamat")
    @Expose
    private String alamat;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
