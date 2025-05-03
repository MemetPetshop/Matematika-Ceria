package com.matematikaceria.backend.repository;

import com.matematikaceria.backend.entity.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NilaiRepository extends JpaRepository<Nilai, Long> {
    List<Nilai> findBySiswaUsername(String username);
    List<Nilai> findBySiswaKelas(String kelas);
}
