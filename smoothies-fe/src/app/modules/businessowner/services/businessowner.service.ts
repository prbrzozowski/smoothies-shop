import {Injectable} from "@angular/core";
import {select, Store} from "@ngrx/store";
import {MainState} from "../../../../state/main.state";
import {loadSmoothies, paginationChanged} from "../state/businessowner.actions";
import {distinctUntilChanged, Observable} from "rxjs";
import {SmoothieDto} from "../../../../../target/generated-sources/smoothies-api";
import {selectBusinessOwnerState} from "../state/businessowner.selectors";
import {map} from "rxjs/operators";
import {isEqual} from "lodash-es";
import {Pagination, SmoothiesLoadState} from "../state/businessowner.state";

@Injectable()
export class BusinessOwnerService {

  constructor(private readonly store: Store<MainState>) {
  }

  loadSmoothies(pagination: Pagination): void {
    this.store.dispatch(loadSmoothies({pagination}));
  }

  getSmoothies(): Observable<SmoothieDto[]> {
    return this.store.pipe(select(selectBusinessOwnerState),
      map(state => state.smoothies),
      distinctUntilChanged((l: SmoothieDto[], r: SmoothieDto[]) => {
          return isEqual(l, r);
        }
      ));
  }

  getSmoothiesLoadState(): Observable<SmoothiesLoadState> {
    return this.store.pipe(select(selectBusinessOwnerState),
      map(state => state.smoothiesLoadState),
      distinctUntilChanged((l: SmoothiesLoadState, r: SmoothiesLoadState) => {
          return isEqual(l, r);
        }
      ));
  }

  getTotalSmoothiesCount(): Observable<number> {
    return this.store.pipe(select(selectBusinessOwnerState),
      map(state => state.totalSmoothiesCount),
      distinctUntilChanged());
  }

  paginationChanged(pagination: Pagination) {
    this.store.dispatch(paginationChanged({pagination}));
  }

  getPagination(): Observable<Pagination> {
    return this.store.pipe(select(selectBusinessOwnerState),
      map(state => state.pagination),
      distinctUntilChanged((l: Pagination, r: Pagination) => {
        return isEqual(l, r);
      }));
  }
}
