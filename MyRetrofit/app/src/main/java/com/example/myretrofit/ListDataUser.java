package com.example.myretrofit;

public class ListDataUser {
    private String kode,nama,alamat;

    public ListDataUser(String kode, String nama, String alamat) {
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
    }

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
