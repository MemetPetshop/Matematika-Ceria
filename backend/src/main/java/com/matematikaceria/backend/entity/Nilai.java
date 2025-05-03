package com.matematikaceria.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "nilai")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "siswa_id")
    private User siswa;

    @ManyToOne
    @JoinColumn(name = "topik_id")
    private Topik topik;

    private int skor;
    private LocalDateTime waktuSubmit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSiswa() {
        return siswa;
    }

    public void setSiswa(User siswa) {
        this.siswa = siswa;
    }

    public Topik getTopik() {
        return topik;
    }

    public void setTopik(Topik topik) {
        this.topik = topik;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public LocalDateTime getWaktuSubmit() {
        return waktuSubmit;
    }

    public void setWaktuSubmit(LocalDateTime waktuSubmit) {
        this.waktuSubmit = waktuSubmit;
    }
}
