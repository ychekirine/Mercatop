import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayerListComponent } from './player/player-list/player-list.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomePageComponent } from './home-page/home-page.component';
import { PlayerAddComponent } from './player/player-add/player-add.component';


@NgModule({
  declarations: [
    AppComponent,
    PlayerListComponent,
    HomePageComponent,
    PlayerAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
