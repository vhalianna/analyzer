package com.val.gerencial.model;

public enum Caracter {
    P("P", "Permanente"),
    T("T", "Transitorio");

    private final String sigla;
    private final String descripcion;

    Caracter(String sigla, String descripcion) {
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