package com.val.gerencial.model;

import jakarta.persistence.*;


@Entity
@Table(name = "liquidacion")

public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Relación con Persona
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    // Relación con Cargo
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Column (name = "ano_liqui")
    private int anoLiqui;

    @Column (name = "mes_liqui")
    private int mesLiqui;

    @Column (name = "nro_liqui")
    private int nroLiqui;

    @Column (name = "dias_trab")
    private int diasTrab;

    @Column (name = "rem_c_apor")
    private Double remCApor;

    @Column (name = "rem_s_apor")
    private Double remSApor;

    @Column (name = "porc_aplic")
    private Double porcAplic;

    @Column (name = "en_banco")
    private String enBanco;

    @Column (name = "codigo_banco")
    private int codigoBanco;

    public Liquidacion(Persona persona, Cargo cargo, int anoLiqui, int mesLiqui, int nroLiqui, int diasTrab, Double remCApor,
            Double remSApor, Double porcAplic, String enBanco, int codigoBanco) {
        this.persona = persona;
        this.cargo = cargo;
        this.anoLiqui = anoLiqui;
        this.mesLiqui = mesLiqui;
        this.nroLiqui = nroLiqui;
        this.diasTrab = diasTrab;
        this.remCApor = remCApor;
        this.remSApor = remSApor;
        this.porcAplic = porcAplic;
        this.enBanco = enBanco;
        this.codigoBanco = codigoBanco;
    }

    public Liquidacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getAnoLiqui() {
        return anoLiqui;
    }

    public void setAnoLiqui(int anoLiqui) {
        this.anoLiqui = anoLiqui;
    }

    public int getMesLiqui() {
        return mesLiqui;
    }

    public void setMesLiqui(int mesLiqui) {
        this.mesLiqui = mesLiqui;
    }

    public int getNroLiqui() {
        return nroLiqui;
    }

    public void setNroLiqui(int nroLiqui) {
        this.nroLiqui = nroLiqui;
    }

    public int getDiasTrab() {
        return diasTrab;
    }

    public void setDiasTrab(int diasTrab) {
        this.diasTrab = diasTrab;
    }

    public Double getRemCApor() {
        return remCApor;
    }

    public void setRemCApor(Double remCApor) {
        this.remCApor = remCApor;
    }

    public Double getRemSApor() {
        return remSApor;
    }

    public void setRemSApor(Double remSApor) {
        this.remSApor = remSApor;
    }

    public Double getPorcAplic() {
        return porcAplic;
    }

    public void setPorcAplic(Double porcAplic) {
        this.porcAplic = porcAplic;
    }

    public String getEnBanco() {
        return enBanco;
    }

    public void setEnBanco(String enBanco) {
        this.enBanco = enBanco;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public Cargo getCargo() {
    return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Liquidacion {"+"id=" + id + ", persona=" + persona + ", cargo=" + cargo + ", anoLiqui=" + anoLiqui
                + ", mesLiqui=" + mesLiqui + ", nroLiqui=" + nroLiqui + ", diasTrab=" + diasTrab + ", remCApor="
                + remCApor + ", remSApor=" + remSApor + ", porcAplic=" + porcAplic + ", enBanco=" + enBanco
                + ", codigoBanco=" + codigoBanco + '}';
    }

}
