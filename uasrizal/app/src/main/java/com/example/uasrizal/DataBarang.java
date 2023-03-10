package com.example.uasrizal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataBarang {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("image")
    @Expose
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
