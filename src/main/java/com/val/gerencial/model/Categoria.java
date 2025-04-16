package com.val.gerencial.model;

public enum Categoria {
    ADCO("ADCO", "Adjunto Completa"),
    ADPA("ADPA", "Adjunto Parcial"),
    ADSI("ADSI", "Adjunto Simple"),
    ASCO("ASCO", "Asistente Completa"),
    ASIC("ASIC", "Asistente Completa"),
    ASIP("ASIP", "Asistente Parcial"),
    ASIS("ASIS", "Asistente Simple"),
    ASPA("ASPA", "Asistente Parcial"),
    ASSI("ASSI", "Asistente Simple"),
    AYPA("ASIS", "Ayudante Parcial"),
    AYSI("AYSI", "Ayudante Simple"),
    TICO("TICO", "Titular Completa"),
    TIPA("TIPA", "Titular Parcial"),
    TISI("TISI", "Titular Simple");

    private final String sigla;
    private final String descripcion;

    Categoria(String sigla, String descripcion) {
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
