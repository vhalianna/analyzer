import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from './persona.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private baseUrl = 'http://localhost:8080/api/personas';

  constructor(private http: HttpClient) {}

  getAllPersonas(): Observable<Persona[]> {
    return this.http.get<Persona[]>(this.baseUrl);
  }
}
