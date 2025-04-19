import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatListModule } from '@angular/material/list';

import { Partida } from './partida.model';
import { PartidaService } from './partida.service';

@Component({
  selector: 'app-partida',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatListModule
  ],
  templateUrl: './partida.component.html'
})
export class PartidaComponent implements OnInit {
  partidas: Partida[] = [];
  partidaSeleccionada!: Partida;
  periodos: { ano: number, mes: number, cantidad: number }[] = [];

  constructor(private partidaService: PartidaService) {}

  ngOnInit(): void {
    this.partidaService.getAll().subscribe({
      next: (data) => this.partidas = data,
      error: (err) => console.error('Error al cargar partidas:', err)
    });
  }

  cargarPeriodos(): void {
    if (!this.partidaSeleccionada) return;
    this.partidaService.getPeriodosByPartida(this.partidaSeleccionada.id).subscribe({
      next: (data) => this.periodos = data,
      error: (err) => console.error('Error al cargar periodos:', err)
    });
  }
}