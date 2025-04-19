package com.val.gerencial.model;

public enum TipoEstado {
    A("A", "Activo"),
    P("p", "Pasivo");
    private final String sigla;
    private final String descripcion;

    TipoEstado(String sigla, String descripcion) {
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