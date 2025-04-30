package com.matematikaceria.backend.service;

import com.matematikaceria.backend.entity.Topik;
import com.matematikaceria.backend.repository.TopikRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopikService {

    private final TopikRepository topikRepository;

    public TopikService(TopikRepository topikRepository) {
        this.topikRepository = topikRepository;
    }

    public Topik simpanTopik(Topik topik) {
        return topikRepository.save(topik);
    }

    public List<Topik> ambilSemuaTopik() {
        return topikRepository.findAll();
    }

    public Topik ambilTopikById(Long id) {
        return topikRepository.findById(id).orElse(null);
    }

    public void hapusTopik(Long id) {
        topikRepository.deleteById(id);
    }
}
