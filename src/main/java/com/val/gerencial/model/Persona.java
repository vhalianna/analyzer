package com.val.gerencial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nro_legaj")
    private int nroLegaj;

    @Column(name = "desc_apyno")
    private String descApyno;

    @Column(name = "cuil")
    private String cuil;

    @Column(name = "cant_anios")
    private int cantAnios;

    @Column(name = "ano_antig")
    private int anoAntig;

    @Column(name = "mes_antig")
    private int mesAntig;

    @Column(name = "tipo_escal")
    private String tipoEscal;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Cargo> cargos = new ArrayList<>();

    public Persona() {
    }

    public Persona(int nroLegaj, String descApyno, String cuil, int cantAnios, int anoAntig, int mesAntig,
            String tipoEscal) {
        this.nroLegaj = nroLegaj;
        this.descApyno = descApyno;
        this.cuil = cuil;
        this.cantAnios = cantAnios;
        this.anoAntig = anoAntig;
        this.mesAntig = mesAntig;
        this.tipoEscal = tipoEscal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNroLegaj() {
        return nroLegaj;
    }

    public void setNroLegaj(int nroLegaj) {
        this.nroLegaj = nroLegaj;
    }

    public String getDescApyno() {
        return descApyno;
    }

    public void setDescApyno(String descApyno) {
        this.descApyno = descApyno;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public int getCantAnios() {
        return cantAnios;
    }

    public void setCantAnios(int cantAnios) {
        this.cantAnios = cantAnios;
    }

    public int getAnoAntig() {
        return anoAntig;
    }

    public void setAnoAntig(int anoAntig) {
        this.anoAntig = anoAntig;
    }

    public int getMesAntig() {
        return mesAntig;
    }

    public void setMesAntig(int mesAntig) {
        this.mesAntig = mesAntig;
    }

    public String getTipoEscal() {
        return tipoEscal;
    }

    public void setTipoEscal(String tipoEscal) {
        this.tipoEscal = tipoEscal;
    }

  public List<Cargo> getCargos() {
    return cargos;
  }

  public void setCargos(List<Cargo> cargos) {
    this.cargos = cargos;
  }

  @Override
    public String toString() {
        return "Persona [id=" + id + ", nroLegaj=" + nroLegaj + ", descApyno=" + descApyno + ", cuil=" + cuil
                + ", cantAnios=" + cantAnios + ", anoAntig=" + anoAntig + ", mesAntig=" + mesAntig + ", tipoEscal="
                + tipoEscal + "]";
    }

}
