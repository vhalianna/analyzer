package com.val.gerencial.model;

import jakarta.persistence.*;


@Entity
@Table(name = "imputacion")

public class Imputacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Relación con Liquidacion
    @ManyToOne
    @JoinColumn(name = "liquidacion_id")
    private Liquidacion liquidacion;

    @Column (name = "codn_imput")
    private String codnImput;

    @Column (name = "codn_fuent")
    private int codnFuent;

    @Column (name = "codn_depen")
    private int codnDepen;

    @Column (name = "nro_inciso")
    private int nroInciso;

    @Column (name = "porc_imput")
    private Double porcImput;

    @Column (name = "imp_gasto")
    private Double impGasto;

    @Column (name = "imp_bruto")
    private Double impBruto;

    @Column (name = "imp_netos")
    private Double impNetos;

    @Column (name = "imp_dctos")
    private Double impDctos;

    @Column (name = "imp_aport")
    private Double impAport;

    @Column (name = "imp_fliar")
    private Double impFliar;

    public Imputacion(Liquidacion liquidacion, String codnImput, int codnFuent, int codnDepen, int nroInciso,
            Double porcImput, Double impGasto, Double impBruto, Double impNetos, Double impDctos, Double impAport,
            Double impFliar) {
        this.liquidacion = liquidacion;
        this.codnImput = codnImput;
        this.codnFuent = codnFuent;
        this.codnDepen = codnDepen;
        this.nroInciso = nroInciso;
        this.porcImput = porcImput;
        this.impGasto = impGasto;
        this.impBruto = impBruto;
        this.impNetos = impNetos;
        this.impDctos = impDctos;
        this.impAport = impAport;
        this.impFliar = impFliar;
    }

    public Imputacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Liquidacion getLiquidacion() {
        return liquidacion;
    }

    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }

    public String getCodnImput() {
        return codnImput;
    }

    public void setCodnImput(String codnImput) {
        this.codnImput = codnImput;
    }

    public int getCodnFuent() {
        return codnFuent;
    }

    public void setCodnFuent(int codnFuent) {
        this.codnFuent = codnFuent;
    }

    public int getCodnDepen() {
        return codnDepen;
    }

    public void setCodnDepen(int codnDepen) {
        this.codnDepen = codnDepen;
    }

    public int getNroInciso() {
        return nroInciso;
    }

    public void setNroInciso(int nroInciso) {
        this.nroInciso = nroInciso;
    }

    public Double getPorcImput() {
        return porcImput;
    }

    public void setPorcImput(Double porcImput) {
        this.porcImput = porcImput;
    }

    public Double getImpGasto() {
        return impGasto;
    }

    public void setImpGasto(Double impGasto) {
        this.impGasto = impGasto;
    }

    public Double getImpBruto() {
        return impBruto;
    }

    public void setImpBruto(Double impBruto) {
        this.impBruto = impBruto;
    }

    public Double getImpNetos() {
        return impNetos;
    }

    public void setImpNetos(Double impNetos) {
        this.impNetos = impNetos;
    }

    public Double getImpDctos() {
        return impDctos;
    }

    public void setImpDctos(Double impDctos) {
        this.impDctos = impDctos;
    }

    public Double getImpAport() {
        return impAport;
    }

    public void setImpAport(Double impAport) {
        this.impAport = impAport;
    }

    public Double getImpFliar() {
        return impFliar;
    }

    public void setImpFliar(Double impFliar) {
        this.impFliar = impFliar;
    }

    @Override
    public String toString() {
        return "Imputacion {" + "id=" + id + ", liquidacion=" + liquidacion + ", codnImput=" + codnImput
                + ", codnFuent=" + codnFuent + ", codnDepen=" + codnDepen + ", nroInciso=" + nroInciso + ", porcImput="
                + porcImput + ", impGasto=" + impGasto + ", impBruto=" + impBruto + ", impNetos=" + impNetos
                + ", impDctos=" + impDctos + ", impAport=" + impAport + ", impFliar=" + impFliar + '}';
    }
 
 
}
