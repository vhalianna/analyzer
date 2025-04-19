import { Routes } from '@angular/router';

import { UploadComponent } from './features/upload/upload.component';
import { ListGerencialComponent } from './features/list-gerencial/list-gerencial.component';
import { PersonaComponent } from './features/persona/persona.component';
import { CargoComponent } from './features/cargo/cargo.component';
import { InicioComponent } from './features/inicio/inicio.component';
import { PartidaComponent } from './features/partida/partida.component';

export const routes: Routes = [
    { path: 'upload', component: UploadComponent },
    { path: 'lista', component: ListGerencialComponent },
    { path: 'personas', component: PersonaComponent },
    { path: 'cargos', component: CargoComponent },
    { path: 'cargos/:personaid', component: CargoComponent },
    { path: 'inicio', component: InicioComponent },
    { path: 'partidas', component: PartidaComponent },
    { path: '', redirectTo: 'inicio', pathMatch: 'full' }
];
