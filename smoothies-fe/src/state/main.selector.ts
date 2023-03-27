import {createFeatureSelector} from '@ngrx/store';
import {MainState} from './main.state';

export const selectMainState = createFeatureSelector<MainState>('main');
