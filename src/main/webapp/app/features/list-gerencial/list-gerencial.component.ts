import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

export interface Gerencial {
  id?: number;

  codn_fuent: number;
  codn_depen: number;
  codn_imput: string;
  nro_inciso: number;
  nro_legaj: number;
  desc_apyno: string;
  cant_anios: number;
  ano_antig: number;
  mes_antig: number;
  nro_cargo: number;

  codc_categ: '...' | string;       // Reemplazá '...' con los valores posibles si tenés el enum
  codc_dedic: '...' | string;
  tipo_escal: string;
  codc_carac: '...' | string;

  codc_uacad: number;
  codc_regio: string;
  fec_alta: string;                 // ISO date string (yyyy-MM-dd)
  fec_baja: string;

  porc_imput: number;
  imp_gasto: number;
  imp_bruto: number;
  imp_netos: number;
  imp_dctos: number;
  imp_aport: number;
  imp_fliar: number;

  ano_liqui: number;
  mes_liqui: number;
  nro_liqui: number;
  tipo_estad: '...' | string;

  cuil: string;
  hs_catedra: number;
  dias_trab: number;

  rem_c_apor: number;
  otr_no_rem: number;
  rem_s_apor: number;
  porc_aplic: number;

  coddependesemp: number;
  cod_clasif_cargo: string;
  tipo_carac: '...' | string;

  en_banco: string;
  codigo_banco: number;
}


@Component({
  selector: 'app-list-gerencial',
  imports: [FormsModule],
  templateUrl: './list-gerencial.component.html',
  styleUrls: ['./list-gerencial.component.css']
})
export class ListGerencialComponent implements OnInit {
  datos: Gerencial[] = [];
  cargando = true;
  mensaje = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Gerencial[]>('http://localhost:8080/api/gerencial/lista').subscribe({
      next: (data) => {
        this.datos = data;
        this.cargando = false;
      },
      error: (error) => {
        this.mensaje = 'Error al cargar los datos';
        this.cargando = false;
        console.error(error);
      }
    });
  }

  filtro: Partial<Gerencial> = {};
get datosFiltrados(): Gerencial[] {
  return this.datos.filter(item => {
    return Object.entries(this.filtro).every(([key, val]) => {
      if (val === null || val === '') return true;
      const value = (item as any)[key];
      return value?.toString().toLowerCase().includes(val.toString().toLowerCase());
    });
  });
}
}
