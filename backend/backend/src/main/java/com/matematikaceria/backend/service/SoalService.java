package com.matematikaceria.backend.service;

import com.matematikaceria.backend.entity.Soal;
import com.matematikaceria.backend.entity.Topik;
import com.matematikaceria.backend.repository.SoalRepository;
import com.matematikaceria.backend.repository.TopikRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoalService {

    private final SoalRepository soalRepository;
    private final TopikRepository topikRepository;

    public SoalService(SoalRepository soalRepository, TopikRepository topikRepository) {
        this.soalRepository = soalRepository;
        this.topikRepository = topikRepository;
    }

    public Soal simpan(Soal soal) {
        return soalRepository.save(soal);
    }

    public List<Soal> getByTopikId(Long topikId) {
        Topik topik = topikRepository.findById(topikId).orElse(null);
        if (topik == null) return List.of();
        return soalRepository.findByTopik(topik);
    }

    public void hapusById(Long id) {
        soalRepository.deleteById(id);
    }
}
