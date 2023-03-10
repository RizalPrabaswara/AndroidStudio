package com.example.uasrizal;

public class ListDataSupplier {
    private String idsupplier,namasupplier,notelepon,namabarang,imagesupplier;

    public ListDataSupplier(String idsupplier, String namasupplier, String notelepon, String namabarang, String imagesupplier) {
        this.idsupplier = idsupplier;
        this.namasupplier = namasupplier;
        this.notelepon = notelepon;
        this.namabarang = namabarang;
        this.imagesupplier = imagesupplier;
    }

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
