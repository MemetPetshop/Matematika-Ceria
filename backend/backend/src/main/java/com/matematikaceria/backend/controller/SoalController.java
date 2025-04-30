package com.matematikaceria.backend.controller;

import com.matematikaceria.backend.entity.Soal;
import com.matematikaceria.backend.service.SoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soal")
@CrossOrigin(origins = "*")
public class SoalController {

    private final SoalService soalService;

    public SoalController(SoalService soalService) {
        this.soalService = soalService;
    }

    @PostMapping("/buat")
    public ResponseEntity<Soal> buatSoal(@RequestBody Soal soal) {
        return ResponseEntity.ok(soalService.simpan(soal));
    }

    @GetMapping("/topik/{topikId}")
    public ResponseEntity<List<Soal>> getSoalByTopik(@PathVariable Long topikId) {
        return ResponseEntity.ok(soalService.getByTopikId(topikId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hapusSoal(@PathVariable Long id) {
        soalService.hapusById(id);
        return ResponseEntity.ok("Soal berhasil dihapus");
    }
}
