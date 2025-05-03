// 📁 src/main/java/com/matematikaceria/backend/entity/Topik.java

package com.matematikaceria.backend.entity;

import jakarta.persistence.*;

import java.util.List;

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
    private String deskripsi;

    @OneToMany(mappedBy = "topik", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Soal> soalList;

    @OneToMany(mappedBy = "topik", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nilai> nilaiList;

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

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public List<Soal> getSoalList() { return soalList; }
    public void setSoalList(List<Soal> soalList) { this.soalList = soalList; }

    public List<Nilai> getNilaiList() { return nilaiList; }
    public void setNilaiList(List<Nilai> nilaiList) { this.nilaiList = nilaiList; }
}
