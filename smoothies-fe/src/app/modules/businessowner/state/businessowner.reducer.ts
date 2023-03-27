import {Action, createReducer, on} from '@ngrx/store';
import {cloneDeep} from 'lodash-es';
import {BusinessOwnerState, SmoothiesLoadState} from "./businessowner.state";
import {loadSmoothies, paginationChanged, smoothiesLoaded, smoothiesLoadError} from "./businessowner.actions";

const initialState: BusinessOwnerState = {
  smoothiesLoadState: SmoothiesLoadState.BEING_LOADED,
  smoothies: [],
  totalSmoothiesCount: 0,
  pagination: {
    page: 0,
    pageSize: 5
  }
};

export const businessOwnerReducer = createReducer(initialState,
  on(loadSmoothies, (state: BusinessOwnerState) => {
    const newState: BusinessOwnerState = cloneDeep(state);
    newState.smoothiesLoadState = SmoothiesLoadState.BEING_LOADED;
    return newState;
  }),
  on(smoothiesLoaded, (state: BusinessOwnerState, {response}) => {
    const newState: BusinessOwnerState = cloneDeep(state);
    newState.smoothiesLoadState = SmoothiesLoadState.LOADED_SUCCESSFULLY;
    newState.smoothies = response.smoothies;
    newState.totalSmoothiesCount = response.totalResultsCount;
    return newState;
  }),
  on(smoothiesLoadError, (state: BusinessOwnerState) => {
    const newState: BusinessOwnerState = cloneDeep(state);
    newState.smoothiesLoadState = SmoothiesLoadState.LOAD_ERROR;
    return newState;
  }),
  on(paginationChanged, (state: BusinessOwnerState, {pagination}) => {
    const newState: BusinessOwnerState = cloneDeep(state);
    newState.pagination = pagination;
    return newState;
  }),
);

export function reducer(state: BusinessOwnerState, action: Action): BusinessOwnerState {
  return businessOwnerReducer(state, action);
}

