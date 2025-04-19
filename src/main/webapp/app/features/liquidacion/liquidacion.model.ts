import { Cargo } from '../cargo/cargo.model';

export interface Liquidacion {
  id: number;
  persona?: any; // Podés definir `Persona` si querés
  cargo: Cargo;
  anoLiqui: number;
  mesLiqui: number;
  nroLiqui: number;
  diasTrab: number;
  remCApor: number;
  remSApor: number;
  porcAplic: number;
  enBanco: string;
  codigoBanco: number;
  showImp?: boolean; // Para expandir imputaciones
}