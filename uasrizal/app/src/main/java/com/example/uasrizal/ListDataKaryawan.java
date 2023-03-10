package com.example.uasrizal;

public class ListDataKaryawan {
    private String idkaryawan,namakaryawan,jabatan,gaji,imagekaryawan;

    public ListDataKaryawan(String idkaryawan, String namakaryawan, String jabatan, String gaji, String imagekaryawan) {
        this.idkaryawan = idkaryawan;
        this.namakaryawan = namakaryawan;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.imagekaryawan = imagekaryawan;
    }

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
