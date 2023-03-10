package com.example.mykeenam;

public class Listisi {
    private String nama;
    private String alamat;
    private String telp;
    private int foto;

    public Listisi(String nama, String alamat, String telp, int foto) {
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.foto = foto;
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

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
