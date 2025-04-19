package com.val.gerencial.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "cargo")
public class Cargo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column (name = "nro_cargo")
  private int nroCargo;

  @Column (name = "codc_categ")
  private Categoria codcCateg;

  @Column (name = "codc_carac")
  private Caracter codcCarac;

  @Column (name = "tipo_carac")
  private TipoCaracter tipoCarac;

  @Column (name = "fec_alta")
  private LocalDate fecAlta;

  @Column (name = "fec_baja")
  private LocalDate fecBaja;

  @Column (name = "tipo_estad")
  private TipoEstado tipoEstad;

  @Column (name = "hs_catedra")
  private int hsCatedra;

  @ManyToOne
  @JoinColumn(name = "persona_id")
  private Persona persona;

  public Cargo(int nroCargo, Categoria codcCateg, Caracter codcCarac, TipoCaracter  tipoCarac, LocalDate fecAlta, LocalDate fecBaja, TipoEstado tipoEstad, int hsCatedra, Persona persona) {
    this.nroCargo = nroCargo;
    this.codcCateg = codcCateg;
    this.codcCarac = codcCarac;
    this.tipoCarac = tipoCarac;
    this.fecAlta = fecAlta;
    this.fecBaja = fecBaja;
    this.tipoEstad = tipoEstad;
    this.hsCatedra = hsCatedra;
    this.persona = persona;
  }

  public Cargo(){

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getNroCargo() {
    return nroCargo;
  }

  public void setNroCargo(int nroCargo) {
    this.nroCargo = nroCargo;
  }

  public Categoria getCodcCateg() {
    return codcCateg;
  }

  public void setCodcCateg(Categoria codcCateg) {
    this.codcCateg = codcCateg;
  }

  public Caracter getCodcCarac() {
    return codcCarac;
  }

  public void setCodcCarac(Caracter codcCarac) {
    this.codcCarac = codcCarac;
  }

  public String getTipoCarac() {
    return tipoCarac.toString();
  }

  public void setTipoCarac(TipoCaracter tipoCarac) {
    this.tipoCarac = tipoCarac;
  }

  public LocalDate getFecAlta() {
    return fecAlta;
  }

  public void setFecAlta(LocalDate fecAlta) {
    this.fecAlta = fecAlta;
  }

  public LocalDate getFecBaja() {
    return fecBaja;
  }

  public void setFecBaja(LocalDate fecBaja) {
    this.fecBaja = fecBaja;
  }

  public TipoEstado getTipoEstad() {
    return tipoEstad;
  }

  public void setTipoEstad(TipoEstado tipoEstad) {
    this.tipoEstad = tipoEstad;
  }

  public int getHsCatedra() {
    return hsCatedra;
  }

  public void setHsCatedra(int hsCatedra) {
    this.hsCatedra = hsCatedra;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  @Override
  public String toString() {
    return "Cargo{" +
      "id=" + id +
      ", nroCargo=" + nroCargo +
      ", codcCateg='" + codcCateg + '\'' +
      ", codcCarac='" + codcCarac + '\'' +
      ", tipoCarac=" + tipoCarac +
      ", fecAlta=" + fecAlta +
      ", fecBaja=" + fecBaja +
      ", tipoEstad=" + tipoEstad +
      ", hsCatedra=" + hsCatedra +
      ", persona=" + persona +
      '}';
  }
}
