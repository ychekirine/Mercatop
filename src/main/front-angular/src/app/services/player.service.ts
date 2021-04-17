import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Player} from "../entities/player";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http : HttpClient) { }

  postPlayer(player: Player): Observable<Player> {
    const url = 'http://localhost:8080/api/v1/player';

    return this.http.post<Player>(url, player);
  }


  getPlayers(): Observable<Player[]> {
    const url = 'http://localhost:8080/api/v1/player';
    const optionRequete = {
      headers: new HttpHeaders({
        "Access-Control-Allow-Origin": "*"

      })
    };
    console.log("here");
    return this.http.get<Player[]>(url, optionRequete);
  }
}







