import {Statistics} from "./statistics";
import {PositionEnum} from "../enums/positionEnum";

export class Player {

  constructor(
    public name: string,
    public lastname: string,
    public email: string,
    public dob:Date,
    public height: number,
    public weight: number,
    public pos: PositionEnum[],
    public statisticsList: Statistics[]
  ) {
  }

}
