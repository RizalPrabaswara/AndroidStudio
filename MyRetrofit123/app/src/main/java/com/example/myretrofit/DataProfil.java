package com.example.myretrofit;

import com.google.gson.annotations.Expose;

public class DataProfil {
    @Expose
    private String kode;
    @Expose
    private String nama;
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
