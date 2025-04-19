export interface Cargo {
    id: number;
    nroCargo: number;
    codcCateg: string;
    codcCarac: string;
    tipoCarac: string;
    fecAlta: Date;
    fecBaja: Date | null;
    tipoEstad: string;
    hsCatedra: number;
    showLiqui?: boolean;
  }