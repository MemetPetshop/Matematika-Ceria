package com.matematikaceria.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "topik")
public class Topik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namaTopik;
    private String deskripsiTopik;
    private String jumlahSoal;
    private String durasiMenit;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaTopik() { return namaTopik; }
    public void setNamaTopik(String namaTopik) { this.namaTopik = namaTopik; }

    public String getDeskripsiTopik() { return deskripsiTopik; }
    public void setDeskripsiTopik(String deskripsiTopik) { this.deskripsiTopik = deskripsiTopik; }

    public String getJumlahSoal() { return jumlahSoal; }
    public void setJumlahSoal(String jumlahSoal) { this.jumlahSoal = jumlahSoal; }

    public String getDurasiMenit() { return durasiMenit; }
    public void setDurasiMenit(String durasiMenit) { this.durasiMenit = durasiMenit; }
}
