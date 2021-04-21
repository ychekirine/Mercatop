import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Player} from "../entities/player";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http : HttpClient) { }


  getPlayers(): Observable<Player[]> {
    const url = 'http://localhost:8080/api/v1/player/all';
    return this.http.get<Player[]>(url);
  }

  getPlayer(id: number): Observable<Player> {
    const url = 'http://localhost:8080/api/v1/player/find/' + id;
    return this.http.get<Player>(url);
  }

  postPlayer(player: Player): Observable<Player> {
    const url = 'http://localhost:8080/api/v1/player/add';
    return this.http.post<Player>(url, player);
  }


  /// TODO : Check how to update (request param or just save the player)

  updatePlayer(player: Player): Observable<Player> {
    const url = 'http://localhost:8080/api/v1/player/update';
    return this.http.put<Player>(url, player);
  }

  deletePLayer(playerId: number): Observable<void> {
    //const url = 'http://localhost:8080/api/v1/player/delete/' + playerId;
    const url = 'http://localhost:8080/api/v1/player/delete/${playerId}'
    return this.http.delete<void>(url);
  }

}
