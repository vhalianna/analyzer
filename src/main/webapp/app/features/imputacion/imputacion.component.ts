import { Component, Input, OnInit } from '@angular/core';
import { Imputacion } from './imputacion.model';
import { Liquidacion } from '../liquidacion/liquidacion.model';
import { ImputacionService } from './imputacion.service';

@Component({
  selector: 'app-imputacion',
  standalone: true,
  imports: [],
  templateUrl: './imputacion.component.html',
  styleUrl: './imputacion.component.css'
})
export class ImputacionComponent implements OnInit {
  @Input() liquidacion!: Liquidacion;
  imputaciones: Imputacion[] = [];

  constructor(private imputacionService: ImputacionService) {}

  ngOnInit(): void {
    if (this.liquidacion?.id) {
      this.imputacionService.getByLiquidacion(this.liquidacion.id).subscribe({
        next: (data) => this.imputaciones = data,
        error: (err) => console.error('Error al obtener imputaciones:', err)
      });
    }
  }
}
