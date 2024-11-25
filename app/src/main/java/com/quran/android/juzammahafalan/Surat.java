package com.quran.android.juzammahafalan;

import java.io.Serializable;
import java.util.List;

public class Surat implements Serializable {

    private String nama;
    private int nomor;
    private int jumlahAyat;
    private List<Ayat> ayatList;

    public Surat(String nama, int nomor, int jumlahAyat) {
        this.nama = nama;
        this.nomor = nomor;
        this.jumlahAyat = jumlahAyat;
    }

    public Surat(String nama, int nomor, int jumlahAyat, List<Ayat> ayatList) {
        this(nama, nomor, jumlahAyat);
        this.ayatList = ayatList;
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

    public List<Ayat> getAyatList() {
        return ayatList;
    }
}
