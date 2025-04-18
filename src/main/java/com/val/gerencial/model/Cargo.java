package com.val.gerencial.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.*;
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
  private String codcCateg;

  @Column (name = "codc_carac")
  private String codcCarac;

  @Column (name = "tipo_carac")
  private char tipoCarac;

  @Column (name = "fec_alta")
  private Date fecAlta;

  @Column (name = "fec_baja")
  private Date fecBaja;

  @Column (name = "tipo_estad")
  private char tipoEstad;

  @Column (name = "hs_catedra")
  private int hsCatedra;

  @ManyToOne
  @JoinColumn(name = "persona_id")
  private Persona persona;

  public Cargo(int nroCargo, String codcCateg, String codcCarac, char tipoCarac, Date fecAlta, Date fecBaja, char tipoEstad, int hsCatedra, Persona persona) {
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

  public String getCodcCateg() {
    return codcCateg;
  }

  public void setCodcCateg(String codcCateg) {
    this.codcCateg = codcCateg;
  }

  public String getCodcCarac() {
    return codcCarac;
  }

  public void setCodcCarac(String codcCarac) {
    this.codcCarac = codcCarac;
  }

  public char getTipoCarac() {
    return tipoCarac;
  }

  public void setTipoCarac(char tipoCarac) {
    this.tipoCarac = tipoCarac;
  }

  public Date getFecAlta() {
    return fecAlta;
  }

  public void setFecAlta(Date fecAlta) {
    this.fecAlta = fecAlta;
  }

  public Date getFecBaja() {
    return fecBaja;
  }

  public void setFecBaja(Date fecBaja) {
    this.fecBaja = fecBaja;
  }

  public char getTipoEstad() {
    return tipoEstad;
  }

  public void setTipoEstad(char tipoEstad) {
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
