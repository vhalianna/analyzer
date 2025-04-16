package com.val.gerencial.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gerencial")
public class Gerencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int codn_fuent;
    private int codn_depen;
    private String codn_imput;
    private int nro_inciso;
    private int nro_legaj;
    private String desc_apyno;
    private int cant_anios;
    private int ano_antig;
    private int mes_antig;
    private int nro_cargo;

    @Enumerated(EnumType.STRING)
    private Categoria codc_categ;

    @Enumerated(EnumType.STRING)
    private Dedicacion codc_dedic;

    private String tipo_escal;

    @Enumerated(EnumType.STRING)
    private Caracter codc_carac;

    private int codc_uacad;
    private String codc_regio;
    private LocalDate fec_alta;
    private LocalDate fec_baja;
    private Double porc_imput;
    private Double imp_gasto;
    private Double imp_bruto;
    private Double imp_netos;
    private Double imp_dctos;
    private Double imp_aport;
    private Double imp_fliar;
    private int ano_liqui;
    private int mes_liqui;
    private String nro_liqui;
    private String tipo_estad;
    private String cuil;
    private int hs_catedra;
    private int dias_trab;
    private Double rem_c_apor;
    private Double otr_no_rem;
    private Double rem_s_apor;
    private Double porc_aplic;
    private int coddependesemp;
    private String cod_clasif_cargo;

    @Enumerated(EnumType.STRING)
    private TipoCaracter tipo_carac;

    private String en_banco;
    private int codigo_banco;

    public Gerencial() {
    }

    public Gerencial(Long id, int codn_fuent, int codn_depen, String codn_imput, int nro_inciso, int nro_legaj, String desc_apyno, int cant_anios,
                     int ano_antig, int mes_antig, int nro_cargo, Categoria codc_categ, Dedicacion codc_dedic, String tipo_escal,
                     Caracter codc_carac, int codc_uacad, String codc_regio, LocalDate fec_alta, LocalDate fec_baja, Double porc_imput,
                     Double imp_gasto, Double imp_bruto, Double imp_netos, Double imp_dctos, Double imp_aport, Double imp_fliar,
                     int ano_liqui, int mes_liqui, String nro_liqui, String tipo_estad, String cuil, int hs_catedra, int dias_trab,
                     Double rem_c_apor, Double otr_no_rem, Double rem_s_apor, Double porc_aplic, int coddependesemp, String cod_clasif_cargo,
                     TipoCaracter tipo_carac, String en_banco, int codigo_banco) {
        this.id = id;
        this.codn_fuent = codn_fuent;
        this.codn_depen = codn_depen;
        this.codn_imput = codn_imput;
        this.nro_inciso = nro_inciso;
        this.nro_legaj = nro_legaj;
        this.desc_apyno = desc_apyno;
        this.cant_anios = cant_anios;
        this.ano_antig = ano_antig;
        this.mes_antig = mes_antig;
        this.nro_cargo = nro_cargo;
        this.codc_categ = codc_categ;
        this.codc_dedic = codc_dedic;
        this.tipo_escal = tipo_escal;
        this.codc_carac = codc_carac;
        this.codc_uacad = codc_uacad;
        this.codc_regio = codc_regio;
        this.fec_alta = fec_alta;
        this.fec_baja = fec_baja;
        this.porc_imput = porc_imput;
        this.imp_gasto = imp_gasto;
        this.imp_bruto = imp_bruto;
        this.imp_netos = imp_netos;
        this.imp_dctos = imp_dctos;
        this.imp_aport = imp_aport;
        this.imp_fliar = imp_fliar;
        this.ano_liqui = ano_liqui;
        this.mes_liqui = mes_liqui;
        this.nro_liqui = nro_liqui;
        this.tipo_estad = tipo_estad;
        this.cuil = cuil;
        this.hs_catedra = hs_catedra;
        this.dias_trab = dias_trab;
        this.rem_c_apor = rem_c_apor;
        this.otr_no_rem = otr_no_rem;
        this.rem_s_apor = rem_s_apor;
        this.porc_aplic = porc_aplic;
        this.coddependesemp = coddependesemp;
        this.cod_clasif_cargo = cod_clasif_cargo;
        this.tipo_carac = tipo_carac;
        this.en_banco = en_banco;
        this.codigo_banco = codigo_banco;
    }


// Getters y setters omitidos por brevedad


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodn_fuent() {
        return codn_fuent;
    }

    public void setCodn_fuent(int codn_fuent) {
        this.codn_fuent = codn_fuent;
    }

    public int getCodn_depen() {
        return codn_depen;
    }

    public void setCodn_depen(int codn_depen) {
        this.codn_depen = codn_depen;
    }

    public int getNro_inciso() {
        return nro_inciso;
    }

    public void setNro_inciso(int nro_inciso) {
        this.nro_inciso = nro_inciso;
    }

    public String getCodn_imput() {
        return codn_imput;
    }

    public void setCodn_imput(String codn_imput) {
        this.codn_imput = codn_imput;
    }

    public int getNro_legaj() {
        return nro_legaj;
    }

    public void setNro_legaj(int nro_legaj) {
        this.nro_legaj = nro_legaj;
    }

    public String getDesc_apyno() {
        return desc_apyno;
    }

    public void setDesc_apyno(String desc_apyno) {
        this.desc_apyno = desc_apyno;
    }

    public int getCant_anios() {
        return cant_anios;
    }

    public void setCant_anios(int cant_anios) {
        this.cant_anios = cant_anios;
    }

    public int getAno_antig() {
        return ano_antig;
    }

    public void setAno_antig(int ano_antig) {
        this.ano_antig = ano_antig;
    }

    public int getMes_antig() {
        return mes_antig;
    }

    public void setMes_antig(int mes_antig) {
        this.mes_antig = mes_antig;
    }

    public int getNro_cargo() {
        return nro_cargo;
    }

    public void setNro_cargo(int nro_cargo) {
        this.nro_cargo = nro_cargo;
    }

    public Categoria getCodc_categ() {
        return codc_categ;
    }

    public void setCodc_categ(Categoria codc_categ) {
        this.codc_categ = codc_categ;
    }

    public Dedicacion getCodc_dedic() {
        return codc_dedic;
    }

    public void setCodc_dedic(Dedicacion codc_dedic) {
        this.codc_dedic = codc_dedic;
    }

    public String getTipo_escal() {
        return tipo_escal;
    }

    public void setTipo_escal(String tipo_escal) {
        this.tipo_escal = tipo_escal;
    }

    public Caracter getCodc_carac() {
        return codc_carac;
    }

    public void setCodc_carac(Caracter codc_carac) {
        this.codc_carac = codc_carac;
    }

    public int getCodc_uacad() {
        return codc_uacad;
    }

    public void setCodc_uacad(int codc_uacad) {
        this.codc_uacad = codc_uacad;
    }

    public int getCodigo_banco() {
        return codigo_banco;
    }

    public void setCodigo_banco(int codigo_banco) {
        this.codigo_banco = codigo_banco;
    }

    public String getEn_banco() {
        return en_banco;
    }

    public void setEn_banco(String en_banco) {
        this.en_banco = en_banco;
    }

    public TipoCaracter getTipo_carac() {
        return tipo_carac;
    }

    public void setTipo_carac(TipoCaracter tipo_carac) {
        this.tipo_carac = tipo_carac;
    }

    public String getCod_clasif_cargo() {
        return cod_clasif_cargo;
    }

    public void setCod_clasif_cargo(String cod_clasif_cargo) {
        this.cod_clasif_cargo = cod_clasif_cargo;
    }

    public int getCoddependesemp() {
        return coddependesemp;
    }

    public void setCoddependesemp(int coddependesemp) {
        this.coddependesemp = coddependesemp;
    }

    public Double getPorc_aplic() {
        return porc_aplic;
    }

    public void setPorc_aplic(Double porc_aplic) {
        this.porc_aplic = porc_aplic;
    }

    public Double getRem_s_apor() {
        return rem_s_apor;
    }

    public void setRem_s_apor(Double rem_s_apor) {
        this.rem_s_apor = rem_s_apor;
    }

    public Double getOtr_no_rem() {
        return otr_no_rem;
    }

    public void setOtr_no_rem(Double otr_no_rem) {
        this.otr_no_rem = otr_no_rem;
    }

    public Double getRem_c_apor() {
        return rem_c_apor;
    }

    public void setRem_c_apor(Double rem_c_apor) {
        this.rem_c_apor = rem_c_apor;
    }

    public int getDias_trab() {
        return dias_trab;
    }

    public void setDias_trab(int dias_trab) {
        this.dias_trab = dias_trab;
    }

    public int getHs_catedra() {
        return hs_catedra;
    }

    public void setHs_catedra(int hs_catedra) {
        this.hs_catedra = hs_catedra;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getTipo_estad() {
        return tipo_estad;
    }

    public void setTipo_estad(String tipo_estad) {
        this.tipo_estad = tipo_estad;
    }

    public String getNro_liqui() {
        return nro_liqui;
    }

    public void setNro_liqui(String nro_liqui) {
        this.nro_liqui = nro_liqui;
    }

    public int getMes_liqui() {
        return mes_liqui;
    }

    public void setMes_liqui(int mes_liqui) {
        this.mes_liqui = mes_liqui;
    }

    public int getAno_liqui() {
        return ano_liqui;
    }

    public void setAno_liqui(int ano_liqui) {
        this.ano_liqui = ano_liqui;
    }

    public Double getImp_fliar() {
        return imp_fliar;
    }

    public void setImp_fliar(Double imp_fliar) {
        this.imp_fliar = imp_fliar;
    }

    public Double getImp_aport() {
        return imp_aport;
    }

    public void setImp_aport(Double imp_aport) {
        this.imp_aport = imp_aport;
    }

    public Double getImp_dctos() {
        return imp_dctos;
    }

    public void setImp_dctos(Double imp_dctos) {
        this.imp_dctos = imp_dctos;
    }

    public Double getImp_netos() {
        return imp_netos;
    }

    public void setImp_netos(Double imp_netos) {
        this.imp_netos = imp_netos;
    }

    public Double getImp_bruto() {
        return imp_bruto;
    }

    public void setImp_bruto(Double imp_bruto) {
        this.imp_bruto = imp_bruto;
    }

    public Double getImp_gasto() {
        return imp_gasto;
    }

    public void setImp_gasto(Double imp_gasto) {
        this.imp_gasto = imp_gasto;
    }

    public Double getPorc_imput() {
        return porc_imput;
    }

    public void setPorc_imput(Double porc_imput) {
        this.porc_imput = porc_imput;
    }

    public LocalDate getFec_baja() {
        return fec_baja;
    }

    public void setFec_baja(LocalDate fec_baja) {
        this.fec_baja = fec_baja;
    }

    public LocalDate getFec_alta() {
        return fec_alta;
    }

    public void setFec_alta(LocalDate fec_alta) {
        this.fec_alta = fec_alta;
    }

    public String getCodc_regio() {
        return codc_regio;
    }

    public void setCodc_regio(String codc_regio) {
        this.codc_regio = codc_regio;
    }
}
