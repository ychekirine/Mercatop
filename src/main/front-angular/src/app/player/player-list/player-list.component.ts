import {Component, OnInit} from '@angular/core';
import {PlayerService} from '../../services/player.service'
import {Player} from "../../entities/player";
import {PositionEnum} from "../../enums/positionEnum";

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {
  model = {} as Player;

  positions = Object.values(PositionEnum);

  constructor(private playerService : PlayerService) { }

  ngOnInit(): void {
    this.playerService.getPlayers().subscribe(
      data => console.log(data)
    )
    this.playerService.getPlayer(2).subscribe(data => this.model = data);
  }


  submitted = false;
  onSubmit() { this.submitted = true;}
  get diagnostic() {return JSON.stringify(this.model)}

}
