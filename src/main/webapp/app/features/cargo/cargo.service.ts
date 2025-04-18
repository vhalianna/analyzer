import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cargo } from './cargo.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CargoService {

  private baseUrl = 'http://localhost:8080/api/cargos';

  constructor(private http: HttpClient) {}

  getCargosByPersona(personaId: number): Observable<Cargo[]> {
    return this.http.get<Cargo[]>(`${this.baseUrl}/persona/${personaId}`);
  }
}
