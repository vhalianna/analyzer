import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Liquidacion } from './liquidacion.model';

@Injectable({
  providedIn: 'root'
})
export class LiquidacionService {
  private baseUrl = 'http://localhost:8080/api/liquidaciones';

  constructor(private http: HttpClient) {}

  getByCargo(id: number): Observable<Liquidacion[]> {
    return this.http.get<Liquidacion[]>(`${this.baseUrl}/cargo/${id}`);
  }
}
