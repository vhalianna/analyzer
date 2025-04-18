import { Routes } from '@angular/router';

import { UploadComponent } from './features/upload/upload.component';
import { ListGerencialComponent } from './features/list-gerencial/list-gerencial.component';
import { PersonaComponent } from './features/persona/persona.component';
import { CargoComponent } from './features/cargo/cargo.component';

export const routes: Routes = [
    { path: 'upload', component: UploadComponent },
    { path: 'lista', component: ListGerencialComponent },
    { path: 'personas', component: PersonaComponent },
    { path: 'cargos', component: CargoComponent },
    { path: 'cargos/:personaid', component: CargoComponent },
    { path: '', component: UploadComponent}
];
