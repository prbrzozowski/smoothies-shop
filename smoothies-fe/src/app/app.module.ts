import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import {BusinessOwnerModule} from './modules/businessowner/businessowner.module'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    FormsModule,
    BrowserModule,
    ButtonModule,
    TableModule,
    BusinessOwnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
