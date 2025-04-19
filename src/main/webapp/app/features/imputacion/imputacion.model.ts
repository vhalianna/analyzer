import { Liquidacion } from '../liquidacion/liquidacion.model';
import { Partida } from '../partida/partida.model';

export interface Imputacion {
  id: number;
  liquidacion: Liquidacion;
  partida: Partida;
  codnFuent: number;
  codnDepen: number;
  nroInciso: number;
  porcImput: number;
  impGasto: number;
  impBruto: number;
  impNetos: number;
  impDctos: number;
  impAport: number;
  impFliar: number;
}