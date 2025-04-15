import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
//import { UploadComponent } from './components/upload/upload.component';

/*@NgModule({
  declarations: [
    AppComponent,
    UploadComponent   // 👈 MUY IMPORTANTE: asegurate que esté aquí
  ],*/
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
