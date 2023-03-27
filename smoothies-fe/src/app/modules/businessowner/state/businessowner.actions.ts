import {createAction, props} from "@ngrx/store";
import {ListAllSmoothiesResponse} from "target/generated-sources/smoothies-api";
import {Pagination} from "./businessowner.state";

export const ACTION_LOAD_SMOOTIHIES = '[businessowner] Load smoothies';
export const loadSmoothies = createAction(ACTION_LOAD_SMOOTIHIES, props<{
  pagination: Pagination
}>());


export const ACTION_SMOOTHIES_LOADED = '[businessowner] Smoothies loaded';
export const smoothiesLoaded = createAction(ACTION_SMOOTHIES_LOADED, props<{
  response: ListAllSmoothiesResponse
}>());


export const ACTION_SMOOTHIES_LOAD_ERROR = '[businessowner] Smoothies load error';
export const smoothiesLoadError = createAction(ACTION_SMOOTHIES_LOAD_ERROR);


export const ACTION_PAGINATON_CHANGED = '[businessowner] Pagination changed';
export const paginationChanged = createAction(ACTION_PAGINATON_CHANGED, props<{
  pagination: Pagination
}>());
