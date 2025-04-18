import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CargoService } from './cargo.service';
import { Cargo } from './cargo.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cargo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cargo.component.html',
  styleUrl: './cargo.component.css'
})
export class CargoComponent implements OnInit {

  cargos: Cargo[] = [];
  personaId!: number;

  constructor(
    private route: ActivatedRoute,
    private cargoService: CargoService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('personaid');
      if (id) {
        this.personaId = +id;
        this.cargarCargos();
      }
    });
  }

  cargarCargos(): void {
    this.cargoService.getCargosByPersona(this.personaId).subscribe({
      next: (data) => {this.cargos = data;},
      error: (err) => {console.error('Error al obtener cargos:', err);}
    });
  }

}
