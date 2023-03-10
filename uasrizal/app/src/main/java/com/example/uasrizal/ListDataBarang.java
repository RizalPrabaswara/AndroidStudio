package com.example.uasrizal;

public class ListDataBarang {
    private String kode,nama,kelas,alamat,image;

    public ListDataBarang(String kode, String nama, String kelas, String alamat, String image) {
        this.kode = kode;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
        this.image = image;
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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
