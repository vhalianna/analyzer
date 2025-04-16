package com.val.gerencial.model;

public class ResumenGerencialDTO {
    private int cantidadCargos;
    private int cantidadDocentes;

    public ResumenGerencialDTO(int cantidadCargos, int cantidadDocentes) {
        this.cantidadCargos = cantidadCargos;
        this.cantidadDocentes = cantidadDocentes;
    }

    public int getCantidadCargos() {
        return cantidadCargos;
    }

    public void setCantidadCargos(int cantidadCargos) {
        this.cantidadCargos = cantidadCargos;
    }

    public int getCantidadDocentes() {
        return cantidadDocentes;
    }

    public void setCantidadDocentes(int cantidadDocentes) {
        this.cantidadDocentes = cantidadDocentes;
    }
}
