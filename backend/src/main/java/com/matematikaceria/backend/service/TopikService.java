// ================= TopikService.java =================
package com.matematikaceria.backend.service;

import com.matematikaceria.backend.entity.Topik;
import com.matematikaceria.backend.entity.TopikTerkirim;
import com.matematikaceria.backend.entity.User;
import com.matematikaceria.backend.model.KirimTopikRequest;
import com.matematikaceria.backend.repository.TopikRepository;
import com.matematikaceria.backend.repository.TopikTerkirimRepository;
import com.matematikaceria.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopikService {

    private final TopikRepository topikRepository;
    private final UserRepository userRepository;
    private final TopikTerkirimRepository topikTerkirimRepository;

    public TopikService(TopikRepository topikRepository, UserRepository userRepository, TopikTerkirimRepository topikTerkirimRepository) {
        this.topikRepository = topikRepository;
        this.userRepository = userRepository;
        this.topikTerkirimRepository = topikTerkirimRepository;
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

    public Topik updateTopik(Long id, Topik updateData) {
        Topik existing = ambilTopikById(id);
        if (existing == null) return null;

        existing.setNamaTopik(updateData.getNamaTopik());
        existing.setDeskripsi(updateData.getDeskripsi());
        existing.setJumlahSoal(updateData.getJumlahSoal());
        existing.setDurasiMenit(updateData.getDurasiMenit());

        return topikRepository.save(existing);
    }

    public void kirimTopikKeKelasGuru(KirimTopikRequest request) {
        Topik topik = topikRepository.findById(request.getIdTopik())
                .orElseThrow(() -> new RuntimeException("Topik tidak ditemukan"));

        User guru = userRepository.findByUsername(request.getUsernameGuru())
                .orElseThrow(() -> new RuntimeException("Guru tidak ditemukan"));

        String kelasGuru = guru.getKelas();
        List<User> siswaKelasSama = userRepository.findByRoleAndKelas("siswa", kelasGuru);

        for (User siswa : siswaKelasSama) {
            TopikTerkirim terkirim = new TopikTerkirim();
            terkirim.setTopik(topik);
            terkirim.setSiswa(siswa);
            terkirim.setWaktuDikirim(LocalDateTime.now());
            topikTerkirimRepository.save(terkirim);
        }
    }
}