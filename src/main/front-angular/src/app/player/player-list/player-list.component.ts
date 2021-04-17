import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../../services/player.service'

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

  constructor(private playerService : PlayerService) { }

  ngOnInit(): void {
    this.playerService.getPlayers().subscribe(
      data => console.log(data)
    )
  }

}
