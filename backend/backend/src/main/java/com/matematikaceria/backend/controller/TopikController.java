package com.matematikaceria.backend.controller;

import com.matematikaceria.backend.entity.Topik;
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

    @PostMapping("/buat")
    public ResponseEntity<Topik> buatTopik(@RequestBody Topik topik) {
        return ResponseEntity.ok(topikService.simpanTopik(topik));
    }

    @GetMapping("/semua")
    public ResponseEntity<List<Topik>> semuaTopik() {
        return ResponseEntity.ok(topikService.ambilSemuaTopik());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topik> ambilTopik(@PathVariable Long id) {
        return ResponseEntity.ok(topikService.ambilTopikById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> hapus(@PathVariable Long id) {
        topikService.hapusTopik(id);
        return ResponseEntity.ok("Topik berhasil dihapus");
    }
}
