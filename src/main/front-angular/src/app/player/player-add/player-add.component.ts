import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Player} from "../../entities/player";
import {HttpErrorResponse} from "@angular/common/http";
import {PlayerService} from "../../services/player.service";

@Component({
  selector: 'app-player-add',
  templateUrl: './player-add.component.html',
  styleUrls: ['./player-add.component.css']
})
export class PlayerAddComponent implements OnInit {

  @Output()
  playerEmit : EventEmitter<any> = new EventEmitter<any>();

  constructor(private playerService : PlayerService) { }

  ngOnInit(): void {
  }

  public onAddPlayer (addForm: NgForm) : void {
    document.getElementById('add-player-form')?.click();
    this.playerService.postPlayer(addForm.value).subscribe(
      (response: Player) => {
        console.log(response);
        this.playerEmit.emit();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        addForm.reset();
      }
    )
  }


}
