package com.example.tugas4;

public class Listmenu {
    private String nama,tahun;
    private int foto;

    public Listmenu(String nama, String tahun, int foto) {
        this.nama = nama;
        this.tahun = tahun;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
