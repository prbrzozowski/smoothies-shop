import {createFeatureSelector} from "@ngrx/store";
import {BusinessOwnerState} from "./businessowner.state";

export const selectBusinessOwnerState = createFeatureSelector<BusinessOwnerState>('business-owner');
