package com.matematikaceria.backend.model;

import java.util.Map;

public class JawabanRequest {
    private Long idTopik;
    private String username;
    private Map<Long, String> jawabanSiswa; // key: soalId, value: jawaban

    public Long getIdTopik() {
        return idTopik;
    }

    public void setIdTopik(Long idTopik) {
        this.idTopik = idTopik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Long, String> getJawabanSiswa() {
        return jawabanSiswa;
    }

    public void setJawabanSiswa(Map<Long, String> jawabanSiswa) {
        this.jawabanSiswa = jawabanSiswa;
    }
}
