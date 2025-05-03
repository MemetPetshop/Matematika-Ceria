package com.matematikaceria.backend.controller;

import com.matematikaceria.backend.model.JawabanRequest;
import com.matematikaceria.backend.model.NilaiResponse;
import com.matematikaceria.backend.service.NilaiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nilai")
@CrossOrigin(origins = "*")
public class NilaiController {

    private final NilaiService nilaiService;

    public NilaiController(NilaiService nilaiService) {
        this.nilaiService = nilaiService;
    }

    @PostMapping("/submit")
    public ResponseEntity<NilaiResponse> submitJawaban(@RequestBody JawabanRequest request) {
        NilaiResponse hasil = nilaiService.prosesJawaban(request);
        return ResponseEntity.ok(hasil);
    }

    @GetMapping("/siswa/{username}")
    public ResponseEntity<?> getNilaiSiswa(@PathVariable String username) {
        return ResponseEntity.ok(nilaiService.lihatNilaiSiswa(username));
    }

    @GetMapping("/guru/{kelas}")
    public ResponseEntity<?> getNilaiKelas(@PathVariable String kelas) {
        return ResponseEntity.ok(nilaiService.lihatNilaiKelas(kelas));
    }
}
