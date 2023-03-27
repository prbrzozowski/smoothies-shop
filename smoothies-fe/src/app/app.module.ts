import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {BusinessOwnerModule} from './modules/businessowner/businessowner.module'
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {mainReducer} from "../state/main.reducer";
import {MainEffects} from "../state/main.effects";
import {HttpClientModule} from "@angular/common/http";
import {ApiModule, Configuration} from 'target/generated-sources/smoothies-api';


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
    BusinessOwnerModule,
    HttpClientModule,
    ApiModule.forRoot(() => new Configuration({
      basePath: 'http://localhost:8080'
    })),
    StoreModule.forRoot({main: mainReducer},
      {
        runtimeChecks: {
          strictStateImmutability: true,
          strictActionImmutability: true
        }
      }),
    StoreDevtoolsModule.instrument(),
    EffectsModule.forRoot([MainEffects]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
