package com.matematikaceria.backend.repository;

import com.matematikaceria.backend.entity.Soal;
import com.matematikaceria.backend.entity.Topik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoalRepository extends JpaRepository<Soal, Long> {
    List<Soal> findByTopik(Topik topik);
}
