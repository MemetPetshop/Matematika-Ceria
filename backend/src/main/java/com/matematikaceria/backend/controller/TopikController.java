package com.matematikaceria.backend.controller;

import com.matematikaceria.backend.entity.Topik;
import com.matematikaceria.backend.model.KirimTopikRequest;
import com.matematikaceria.backend.service.TopikService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topik")
@CrossOrigin(origins = "*")
public class TopikController {

    private final TopikService topikService;

    public TopikController(TopikService topikService) {
        this.topikService = topikService;
    }

    @PostMapping
    public ResponseEntity<Topik> simpanTopik(@RequestBody Topik topik) {
        Topik hasil = topikService.simpanTopik(topik);
        return ResponseEntity.ok(hasil);
    }

    @GetMapping
    public ResponseEntity<List<Topik>> ambilSemuaTopik() {
        return ResponseEntity.ok(topikService.ambilSemuaTopik());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topik> ambilTopikById(@PathVariable Long id) {
        return ResponseEntity.ok(topikService.ambilTopikById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topik> updateTopik(@PathVariable Long id, @RequestBody Topik updateData) {
        Topik updated = topikService.updateTopik(id, updateData);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hapusTopik(@PathVariable Long id) {
        topikService.hapusTopik(id);
        return ResponseEntity.ok("Topik berhasil dihapus");
    }

    @PostMapping("/kirim")
    public ResponseEntity<String> kirimTopikKeKelas(@RequestBody KirimTopikRequest request) {
        topikService.kirimTopikKeKelasGuru(request);
        return ResponseEntity.ok("Topik berhasil dikirim ke semua siswa sekelas guru.");
    }
}