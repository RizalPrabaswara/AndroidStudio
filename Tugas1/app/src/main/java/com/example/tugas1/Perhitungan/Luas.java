package com.example.tugas1.Perhitungan;

public class Luas {

    private double Panjang;
    private double Lebar;
    private double Tinggi;
    private double Sisi;

    public double getPanjang() {
        return Panjang;
    }

    public void setPanjang(double panjang) {
        Panjang = panjang;
    }

    public double getLebar() {
        return Lebar;
    }

    public void setLebar(double lebar) {
        Lebar = lebar;
    }

    public double getTinggi() {
        return Tinggi;
    }

    public void setTinggi(double tinggi) {
        Tinggi = tinggi;
    }

    public double getSisi() {
        return Sisi;
    }

    public void setSisi(double sisi) {
        Sisi = sisi;
    }

    public double getLuasPermukaanKubus(){
        return 6 * (Sisi * Sisi);
    }

    public double getLuasPermukaanBalok(){
        return 2 * (Panjang * Lebar + Panjang * Tinggi + Lebar * Tinggi);
    }
}
