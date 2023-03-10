package com.example.projectuas;

public class ListDataUAS {

    private String kode,nama,genre,platform,harga,tahun;

    public ListDataUAS(String kode, String nama, String genre, String platform, String harga, String tahun) {
        this.kode = kode;
        this.nama = nama;
        this.genre = genre;
        this.platform = platform;
        this.harga = harga;
        this.tahun = tahun;
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
