import {Component, OnInit} from '@angular/core';
import {PlayerService} from '../../services/player.service'
import {Player} from "../../entities/player";
import {PositionEnum} from "../../enums/positionEnum";
import {NgForm} from "@angular/forms";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";
import {error} from "@angular/compiler/src/util";

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {


  players= {} as Player[];
  editPlayer: Player | null = {} as Player;
  deletePlayer: Player | null = {} as Player;
  states = PositionEnum;
  //positions = Object.values(PositionEnum);

  constructor(private playerService : PlayerService) { }

  ngOnInit(): void {
    this.getPlayers();
  }

  public getPlayers(): void{
    this.playerService.getPlayers().subscribe(
      (data: Player[]) =>{
        this.players = data;
      }
    )
  }

  public onOpenModal(player:Player| null,mode: string){

    const container = document.getElementById("main-container");
    const button= document.createElement('button');
    button.type= 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if (mode === 'add'){
      button.setAttribute('data-target','#addPlayerModal');
    }
    if (mode === 'edit'){
      this.editPlayer = player;
      button.setAttribute('data-target','#updatePlayerModal');
    }
    if (mode === 'delete'){
      this.deletePlayer = player;
      button.setAttribute('data-target','#deletePlayerModal');
    }
    // @ts-ignore
    container.appendChild(button);
    button.click();
  }

  public onAddPlayer (addForm: NgForm) : void {

    document.getElementById('add-player-form')?.click();
    this.playerService.postPlayer(addForm.value).subscribe(
      (response: Player) => {
        console.log(response);
        this.getPlayers();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        addForm.reset();
      }
    )
  }

  public onUpdatePlayer (player: Player) : void {
    this.playerService.updatePlayer(player).subscribe(
      (response: Player) => {
        console.log(response);
        this.getPlayers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public onDeletePlayer (playerId: number) : void {
    this.playerService.deletePLayer(playerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getPlayers();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public searchPlayer(key: string): void{
    const results: Player[] = [];
    for(const player of this.players){
      if(player.name.toLocaleLowerCase().indexOf(key.toLowerCase()) != -1
        || player.lastName.toLocaleLowerCase().indexOf(key.toLowerCase()) != -1
        || player.email.toLocaleLowerCase().indexOf(key.toLowerCase()) != -1
      ){
        results.push(player)
      }
    }
    this.players = results;
    if (results.length === 0 || !key){
      this.getPlayers()
    }
  }

  /*submitted = false;
  onSubmit() { this.submitted = true;}
  get diagnostic() {return JSON.stringify(this.model)}*/

}
