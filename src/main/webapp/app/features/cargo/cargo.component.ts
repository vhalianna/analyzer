import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CargoService } from './cargo.service';
import { Cargo } from './cargo.model';
import { CommonModule } from '@angular/common';

import { Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Persona } from '../persona/persona.model';
import { LiquidacionComponent } from "../liquidacion/liquidacion.component";
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-cargo',
  standalone: true,
  imports: [CommonModule, LiquidacionComponent, MatButtonModule],
  templateUrl: './cargo.component.html',
  styleUrl: './cargo.component.css'
})
export class CargoComponent implements OnInit {

  cargos: Cargo[] = [];
  personaId!: number;
  persona!: Persona;

  constructor(
    private route: ActivatedRoute,
    @Inject(MAT_DIALOG_DATA) public data: Persona,
    private cargoService: CargoService
  ) {}

  ngOnInit(): void {
    this.persona = this.data;
    this.cargarCargos();
  }

  cargarCargos(): void {
    this.cargoService.getCargosByPersona(this.persona.id!).subscribe({
      next: (data) => {
        // Ordenar por fecha de alta y baja

        this.cargos = data
                      .map(c => ({
                        ...c,
                        fecAlta: new Date(c.fecAlta),
                        fecBaja: c.fecBaja ? new Date(c.fecBaja) : null
                      }))
                      .sort((a, b) => b.fecAlta.getTime() - a.fecAlta.getTime());

      },
      error: (err) => {
        console.error('Error al obtener cargos:', err);
      }
    });
  }

}
