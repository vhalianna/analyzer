import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Imputacion } from './imputacion.model';

@Injectable({
  providedIn: 'root'
})
export class ImputacionService {
  private baseUrl = 'http://localhost:8080/api/imputaciones';

  constructor(private http: HttpClient) {}

  getByLiquidacion(id: number): Observable<Imputacion[]> {
    return this.http.get<Imputacion[]>(`${this.baseUrl}/liquidacion/${id}`);
  }
}
