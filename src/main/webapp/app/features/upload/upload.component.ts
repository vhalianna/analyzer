import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {
  selectedFile: File | null = null;
  mensaje = '';
  cargando = false;

  constructor(private http: HttpClient) {}

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    /*if (file && !file.name.endsWith('.xlsx')) {
      this.mensaje = 'El archivo debe ser .xlsx';
      this.selectedFile = null;
      return;
    }*/
  
    this.selectedFile = file;
  }

  onUpload() {
    this.mensaje = '';
    if (!this.selectedFile) {
      this.mensaje = 'Seleccioná un archivo primero';
      return;
    }
    this.cargando = true;
    const formData = new FormData();
    formData.append('file', this.selectedFile);

    this.http.post('http://localhost:8080/api/gerencial/uploadFile', formData, { responseType: 'text' })
      .subscribe({
        next: () => {this.mensaje = 'Archivo subido exitosamente ✅'; this.cargando = false;},
        error: (error) => {
          console.error(error);
          this.mensaje = 'Error al subir el archivo ❌:  ' + JSON.stringify(error);
          this.cargando = false;
        }
      });
  }
}
