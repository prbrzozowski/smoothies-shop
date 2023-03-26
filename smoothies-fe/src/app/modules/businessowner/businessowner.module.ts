import {CommonModule} from "@angular/common";
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import {NgModule} from '@angular/core';
import {StoreModule} from "@ngrx/store";
import {EffectsModule} from "@ngrx/effects";
import {reducer} from "./state/businessowner.reducer";
import {BusinessownerEffects} from "./state/businessowner.effects";
import {BusinessOwnerService} from "./services/businessowner.service";
import {BusinessownerComponent} from "./components/businessowner.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {SmootiesListComponent} from "./components/smooties-list.component";

@NgModule({
  declarations: [
    BusinessownerComponent,
    SmootiesListComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    ButtonModule,
    TableModule,
    StoreModule.forFeature('business-owner', reducer),
    EffectsModule.forFeature([BusinessownerEffects])
  ],
  providers: [BusinessOwnerService],

  exports: [
    BusinessownerComponent,
    SmootiesListComponent
  ]
})
export class BusinessOwnerModule {
}
