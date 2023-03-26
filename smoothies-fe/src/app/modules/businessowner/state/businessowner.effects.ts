import {Injectable} from '@angular/core';
import {Actions, createEffect, ofType} from '@ngrx/effects';
import {Store} from '@ngrx/store';
import {of} from 'rxjs';
import {BusinessOwnerState} from "./businessowner.state";
import {loadSmoothies, smoothiesLoaded, smoothiesLoadError} from "./businessowner.actions";
import {BusinessOwnerControllerService} from 'target/generated-sources/smoothies-api';
import {HttpErrorResponse} from '@angular/common/http';
import {catchError, map, mergeMap} from 'rxjs/operators';

@Injectable()
export class BusinessownerEffects {
  constructor(
    private readonly actions$: Actions,
    private readonly store$: Store<BusinessOwnerState>,
    private readonly businessOwnerControllerService: BusinessOwnerControllerService) {
  }

  loadSmoothiesAction$ = createEffect(() => this.actions$.pipe(
    ofType(loadSmoothies),
    mergeMap((action) => {
      return this.businessOwnerControllerService.listSmoothies1(action.pagination.page, action.pagination.pageSize)
        .pipe(
          map(response => {
            return smoothiesLoaded({response});
          }),
          catchError((error: HttpErrorResponse) => {
            return of(smoothiesLoadError());
          })
        );
    })));

}

