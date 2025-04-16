package com.val.gerencial.model;

public enum TipoCaracter {
    DEQU("DEQU", "Superior"),
    INAT("INAT", "Interino a Término"),
    INSU("INSU", "Interino Suplente"),
    INTE("INTE", "Interino"),
    ORDI("ORDI", "Ordinario");

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