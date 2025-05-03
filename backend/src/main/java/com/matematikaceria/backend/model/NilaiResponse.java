package com.matematikaceria.backend.model;

public class NilaiResponse {
    private int nilai;
    private int jumlahBenar;
    private int totalSoal;

    public NilaiResponse(int nilai, int jumlahBenar, int totalSoal) {
        this.nilai = nilai;
        this.jumlahBenar = jumlahBenar;
        this.totalSoal = totalSoal;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getJumlahBenar() {
        return jumlahBenar;
    }

    public void setJumlahBenar(int jumlahBenar) {
        this.jumlahBenar = jumlahBenar;
    }

    public int getTotalSoal() {
        return totalSoal;
    }

    public void setTotalSoal(int totalSoal) {
        this.totalSoal = totalSoal;
    }
}
