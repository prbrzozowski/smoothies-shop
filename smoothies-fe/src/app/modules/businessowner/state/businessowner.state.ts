import {SmoothieDto} from "../../../../../target/generated-sources/smoothies-api";


export interface BusinessOwnerState {
  smoothiesLoadState: SmoothiesLoadState;
  smoothies: SmoothieDto[];
  totalSmoothiesCount: number;
  pagination: Pagination;
}

export enum SmoothiesLoadState {
  BEING_LOADED = 'BEING_LOADED',
  LOADED_SUCCESSFULLY = 'LOADED_SUCCESSFULLY',
  LOAD_ERROR = 'LOAD_ERROR',
}

export interface Pagination {
  page: number;
  pageSize: number;
}
