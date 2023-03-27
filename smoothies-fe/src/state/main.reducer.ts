import {Action, createReducer} from '@ngrx/store';
import {MainState} from "./main.state";


const initialState: MainState = {};

export const mainReducer = createReducer(initialState,
);

export function reducer(state: MainState, action: Action): MainState {
  return mainReducer(state, action);
}

