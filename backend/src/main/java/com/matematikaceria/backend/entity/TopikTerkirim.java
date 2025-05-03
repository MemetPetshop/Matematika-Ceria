package com.matematikaceria.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TopikTerkirim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Topik topik;

    @ManyToOne
    private User siswa;

    private LocalDateTime waktuDikirim;

    // Getter dan Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Topik getTopik() { return topik; }
    public void setTopik(Topik topik) { this.topik = topik; }

    public User getSiswa() { return siswa; }
    public void setSiswa(User siswa) { this.siswa = siswa; }

    public LocalDateTime getWaktuDikirim() { return waktuDikirim; }
    public void setWaktuDikirim(LocalDateTime waktuDikirim) { this.waktuDikirim = waktuDikirim; }
}
