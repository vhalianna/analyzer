import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Gerencial {
  id: number;
  desc_apyno: string;
  cuil: string;
  codc_uacad: number;
  codc_categ: string;
  codc_dedic: string;
  fec_alta: string;
  fec_baja: string;
  imp_bruto: number;
  nro_legaj: number;
  tipo_estad: string;
  // Podés agregar más campos si querés mostrar más
}

@Component({
  selector: 'app-list-gerencial',
  imports: [],
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
}
