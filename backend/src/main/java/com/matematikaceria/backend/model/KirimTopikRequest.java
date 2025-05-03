package com.matematikaceria.backend.model;

public class KirimTopikRequest {
    private Long idTopik;
    private String usernameGuru;

    public Long getIdTopik() {
        return idTopik;
    }

    public void setIdTopik(Long idTopik) {
        this.idTopik = idTopik;
    }

    public String getUsernameGuru() {
        return usernameGuru;
    }

    public void setUsernameGuru(String usernameGuru) {
        this.usernameGuru = usernameGuru;
    }
}