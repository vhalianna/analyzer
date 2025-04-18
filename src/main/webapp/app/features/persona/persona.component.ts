import { Component, OnInit } from '@angular/core';
import { Persona } from './persona.model';
import { PersonaService } from './persona.service';

@Component({
  selector: 'app-persona',
  standalone: true,
  imports: [],
  templateUrl: './persona.component.html',
  styleUrl: './persona.component.css'
})
export class PersonaComponent implements OnInit {

  personas: Persona[] = [];

  constructor(private personaService: PersonaService) {}

  ngOnInit(): void {
    this.personaService.getAllPersonas().subscribe({
      next: (data) => this.personas = data,
      error: (err) => console.error('Error al obtener personas:', err)
    });
  }
}
