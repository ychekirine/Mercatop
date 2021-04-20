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
  model = {} as Player;
  positions = Object.values(PositionEnum);

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
      button.setAttribute('data-target','#updatePlayerModal');
    }
    if (mode === 'delete'){
      button.setAttribute('data-target','#deleteEmployeeModal');
    }
    //@ts-ignore: Object is possibly 'null'
    container.appendChild(button);
    button.click();
  }

  public onAddPlayer (addForm: NgForm) : void {

    document.getElementById('add-player-form')?.click();
    this.playerService.postPlayer(addForm.value).subscribe(
      (response: Player) => {
       console.log(response);
       this.getPlayers();
      },
    (error: HttpErrorResponse) => {
        alert(error.message)
    }
    )
  }
  /*submitted = false;
  onSubmit() { this.submitted = true;}
  get diagnostic() {return JSON.stringify(this.model)}*/

}
