import { Component, OnInit } from '@angular/core';
import { RestApiService } from "../shared/rest-api.service";
import { Router } from '@angular/router';


import { HttpClient, HttpHeaders } from '@angular/common/http';


export interface Biere {
  items: Array<{
    name: string;
    alcool: String;
    nbVote: String;
  }>;
}


@Component({
  selector: 'app-beerLeaderBoard',
  templateUrl: './beerLeaderBoard.component.html',
  styleUrls: ['./beerLeaderBoard.component.css']
})



export class beerLeaderBoardComponent implements OnInit {

  const optionRequete = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin':'*',
        'mon-entete-personnalise':'maValeur'
      })
    };



  beerList: Biere[];
  private beerListUrl= 'https://apiweb.cactus-industries.fr/AllBeers';

  constructor(private httpClient: HttpClient) {

    }

  ngOnInit() {

    this.httpClient.get(this.beerListUrl)
    .subscribe(BeerResponse => {
                    this.beerList = BeerResponse.items.map(item => new Beer({
                                        name: item.name,
                                        alcool: item.alcool,
                                        nbVote: item.nbVote
                                    }));
                    });

  }
  dataSource = this.beerList;
}

