import { Component, Input, OnInit } from '@angular/core';
import { Liquidacion } from './liquidacion.model';
import { Cargo } from '../cargo/cargo.model';
import { LiquidacionService } from './liquidacion.service';
import { CommonModule } from '@angular/common';
import { ImputacionComponent } from '../imputacion/imputacion.component'; // ajustar ruta si es necesario


@Component({
  selector: 'app-liquidacion',
  imports: [CommonModule,ImputacionComponent],
  templateUrl: './liquidacion.component.html',
  styleUrl: './liquidacion.component.css'
})
export class LiquidacionComponent implements OnInit{
  @Input() cargo!: Cargo;
  liquidaciones: Liquidacion[] = [];

  constructor(private liquidacionService: LiquidacionService) {}

  ngOnInit(): void {
    if (this.cargo && this.cargo.id) {
      this.liquidacionService.getByCargo(this.cargo.id).subscribe({
        next: (data) => {
          this.liquidaciones = data;
        },
        error: (err) => {
          console.error('Error al obtener liquidaciones:', err);
        }
      });
    }
  }
}