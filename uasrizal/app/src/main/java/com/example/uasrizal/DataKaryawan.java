package com.example.uasrizal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataKaryawan {
    @SerializedName("idkaryawan")
    @Expose
    private String idkaryawan;
    @SerializedName("namakaryawan")
    @Expose
    private String namakaryawan;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gaji")
    @Expose
    private String gaji;
    @SerializedName("imagekaryawan")
    @Expose
    private String imagekaryawan;

    public String getIdkaryawan() {
        return idkaryawan;
    }

    public void setIdkaryawan(String idkaryawan) {
        this.idkaryawan = idkaryawan;
    }

    public String getNamakaryawan() {
        return namakaryawan;
    }

    public void setNamakaryawan(String namakaryawan) {
        this.namakaryawan = namakaryawan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getImagekaryawan() {
        return imagekaryawan;
    }

    public void setImagekaryawan(String imagekaryawan) {
        this.imagekaryawan = imagekaryawan;
    }
}
