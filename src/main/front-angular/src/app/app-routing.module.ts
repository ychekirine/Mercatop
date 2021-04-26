import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { PlayerListComponent } from './player/player-list/player-list.component';

const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'playerList', component: PlayerListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})



export class AppRoutingModule {

}

