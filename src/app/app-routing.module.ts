import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {beerLeaderBoardComponent} from './beerLeaderBoard/beerLeaderBoard.component';
import { BeerFormComponent } from './beer-form/beer-form.component'
import { AppComponent } from './app.component';

const routes: Routes = [
  {path: '',pathMatch: 'full', redirectTo: 'AppComponent'},
  {path: 'leaderBoard', component: beerLeaderBoard},
  {path: 'formComponent', component: BeerFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
