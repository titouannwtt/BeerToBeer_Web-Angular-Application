import { Component } from '@angular/core';

export interface Beer {
  name: string;
  position: number;
  percent: number;
  price: number;
}

const Beer_Data: Beer[] = [
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
  {name: 'kronenbourg', position: 1, percent: 6, price: 3},
];


@Component({
  selector: 'app-beerLeaderBoard',
  templateUrl: './beerLeaderBoard.component.html',
  styleUrls: ['./beerLeaderBoard.component.css']
})
export class beerLeaderBoardComponent {
  title = 'projetBearOrNotToBear';
  displayedColumns: string[] = ['position', 'name', 'percent', 'price'];
  dataSource = Beer_Data;
}
