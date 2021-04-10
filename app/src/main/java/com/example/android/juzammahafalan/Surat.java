package com.example.android.juzammahafalan;

public class Surat {

    private String nama;
    private int nomor;
    private int jumlahAyat;

    public Surat(String nama, int nomor, int jumlahAyat) {
        this.nama = nama;
        this.nomor = nomor;
        this.jumlahAyat = jumlahAyat;
    }

    public String getNama() {
        return nama;
    }

    public int getNomor() {
        return nomor;
    }

    public int getJumlahAyat() {
        return jumlahAyat;
    }
}
