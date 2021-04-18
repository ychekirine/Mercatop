import {seasonTypeEnum} from "../enums/seasonTypeEnum";

export class Statistics {

  constructor(
    public goals: number,
    public assists: number,
    public redCards: number,
    public yellowCards: number,
    public rate: number,
    public saves: number,
    public seasonType:seasonTypeEnum

  ) {
  }
}
