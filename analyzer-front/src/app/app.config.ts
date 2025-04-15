import { provideRouter } from '@angular/router';
import { UploadComponent } from './components/upload/upload.component';

export const appConfig = {
  providers: [
    provideRouter([
      { path: '', component: UploadComponent } // 👈 esto lo muestra como ruta principal
    ])
  ]
};
