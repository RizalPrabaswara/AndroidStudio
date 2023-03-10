package com.example.projectuas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUAS {
    @SerializedName("Kode")
    @Expose
    private String kode;
    @SerializedName("Nama")
    @Expose
    private String nama;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Platform")
    @Expose
    private String platform;
    @SerializedName("Harga")
    @Expose
    private String harga;
    @SerializedName("Tahun")
    @Expose
    private String tahun;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}
