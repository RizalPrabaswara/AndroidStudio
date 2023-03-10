package com.example.uasrizal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSupplier {
    @SerializedName("idsupplier")
    @Expose
    private String idsupplier;
    @SerializedName("namasupplier")
    @Expose
    private String namasupplier;
    @SerializedName("notelepon")
    @Expose
    private String notelepon;
    @SerializedName("namabarang")
    @Expose
    private String namabarang;
    @SerializedName("imagesupplier")
    @Expose
    private String imagesupplier;

    public String getIdsupplier() {
        return idsupplier;
    }

    public void setIdsupplier(String idsupplier) {
        this.idsupplier = idsupplier;
    }

    public String getNamasupplier() {
        return namasupplier;
    }

    public void setNamasupplier(String namasupplier) {
        this.namasupplier = namasupplier;
    }

    public String getNotelepon() {
        return notelepon;
    }

    public void setNotelepon(String notelepon) {
        this.notelepon = notelepon;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getImagesupplier() {
        return imagesupplier;
    }

    public void setImagesupplier(String imagesupplier) {
        this.imagesupplier = imagesupplier;
    }
}
