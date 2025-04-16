import { Routes } from '@angular/router';

import { UploadComponent } from './features/upload/upload.component';
import { ListGerencialComponent } from './features/list-gerencial/list-gerencial.component';

export const routes: Routes = [
    { path: 'upload', component: UploadComponent },
    { path: 'lista', component: ListGerencialComponent },
    { path: '', component: UploadComponent}

];
