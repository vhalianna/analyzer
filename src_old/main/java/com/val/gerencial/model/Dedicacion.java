package com.val.gerencial.model;

public enum Dedicacion {
    COMD("COMD", "Completa"),
    PARC("PARC", "Parcial"),
    SIMP("SIMP", "Simple");

    private final String sigla;
    private final String descripcion;

    Dedicacion(String sigla, String descripcion) {
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
