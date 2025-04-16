package com.val.gerencial.model;

public enum TipoCaracter {
    P("P", "Permanente"),
    T("T", "Transitorio");
    private final String sigla;
    private final String descripcion;

    TipoCaracter(String sigla, String descripcion) {
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