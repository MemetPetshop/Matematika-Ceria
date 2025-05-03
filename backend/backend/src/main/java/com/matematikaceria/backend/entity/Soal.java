package com.matematikaceria.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "soal")
public class Soal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pertanyaan;
    private String opsiA;
    private String opsiB;
    private String opsiC;
    private String opsiD;
    private String jawaban;

    @ManyToOne
    @JoinColumn(name = "topik_id")
    private Topik topik;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPertanyaan() { return pertanyaan; }
    public void setPertanyaan(String pertanyaan) { this.pertanyaan = pertanyaan; }

    public String getOpsiA() { return opsiA; }
    public void setOpsiA(String opsiA) { this.opsiA = opsiA; }

    public String getOpsiB() { return opsiB; }
    public void setOpsiB(String opsiB) { this.opsiB = opsiB; }

    public String getOpsiC() { return opsiC; }
    public void setOpsiC(String opsiC) { this.opsiC = opsiC; }

    public String getOpsiD() { return opsiD; }
    public void setOpsiD(String opsiD) { this.opsiD = opsiD; }

    public String getJawaban() { return jawaban; }
    public void setJawaban(String jawaban) { this.jawaban = jawaban; }

    public Topik getTopik() { return topik; }
    public void setTopik(Topik topik) { this.topik = topik; }
}
