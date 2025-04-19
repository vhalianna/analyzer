import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Partida } from './partida.model';

@Injectable({
  providedIn: 'root'
})
export class PartidaService {

  private baseUrl = 'http://localhost:8080/api/partidas';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Partida[]> {
    return this.http.get<Partida[]>(`${this.baseUrl}`);
  }

  getPeriodosByPartida(partidaId: number): Observable<{ ano: number, mes: number, cantidad: number }[]> {
    return this.http.get<{ ano: number, mes: number, cantidad: number }[]>(
      `${this.baseUrl}/periodos/${partidaId}`
    );
  }
}
