package com.matematikaceria.backend.service;

import com.matematikaceria.backend.entity.Nilai;
import com.matematikaceria.backend.entity.Soal;
import com.matematikaceria.backend.entity.Topik;
import com.matematikaceria.backend.entity.User;
import com.matematikaceria.backend.model.JawabanRequest;
import com.matematikaceria.backend.model.NilaiResponse;
import com.matematikaceria.backend.repository.NilaiRepository;
import com.matematikaceria.backend.repository.SoalRepository;
import com.matematikaceria.backend.repository.TopikRepository;
import com.matematikaceria.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class NilaiService {

    private final SoalRepository soalRepository;
    private final UserRepository userRepository;
    private final TopikRepository topikRepository;
    private final NilaiRepository nilaiRepository;

    public NilaiService(SoalRepository soalRepository, UserRepository userRepository,
                        TopikRepository topikRepository, NilaiRepository nilaiRepository) {
        this.soalRepository = soalRepository;
        this.userRepository = userRepository;
        this.topikRepository = topikRepository;
        this.nilaiRepository = nilaiRepository;
    }

    public NilaiResponse prosesJawaban(JawabanRequest request) {
        Topik topik = topikRepository.findById(request.getIdTopik()).orElseThrow();
        User siswa = userRepository.findByUsername(request.getUsername()).orElseThrow();
        List<Soal> soalList = soalRepository.findByTopik(topik);

        int benar = 0;
        for (Soal soal : soalList) {
            String jawabanSiswa = request.getJawabanSiswa().getOrDefault(soal.getId(), "");
            if (soal.getJawaban().equalsIgnoreCase(jawabanSiswa)) {
                benar++;
            }
        }

        int nilai = (int) Math.round(((double) benar / soalList.size()) * 100);

        Nilai simpan = new Nilai();
        simpan.setSiswa(siswa);
        simpan.setTopik(topik);
        simpan.setSkor(nilai);
        simpan.setWaktuSubmit(LocalDateTime.now());
        nilaiRepository.save(simpan);

        return new NilaiResponse(nilai, benar, soalList.size());
    }

    public List<Nilai> lihatNilaiSiswa(String username) {
        return nilaiRepository.findBySiswaUsername(username);
    }

    public List<Nilai> lihatNilaiKelas(String kelas) {
        return nilaiRepository.findBySiswaKelas(kelas);
    }
}
