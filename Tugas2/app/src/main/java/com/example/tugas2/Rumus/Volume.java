package com.example.tugas2.Rumus;

public class Volume extends Luas {
    public double getVolumeKubus(){
        return (super.getSisi() * super.getSisi() * super.getSisi());
    }

    public double getVolumeBalok(){
        return (super.getPanjang() * super.getLebar() * super.getTinggi());
    }
}
