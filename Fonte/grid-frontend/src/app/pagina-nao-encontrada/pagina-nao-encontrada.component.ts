import { Component, OnInit } from '@angular/core';
import { Tile } from 'src/app/model/tile';

@Component({
  selector: 'app-pagina-nao-encontrada',
  templateUrl: './pagina-nao-encontrada.component.html',
  styleUrls: ['./pagina-nao-encontrada.component.css']
})
export class PaginaNaoEncontradaComponent implements OnInit {

  tiles: Tile[] = [
    {text: 'Página não encontrada', cols: 12, rows: 1, color: ''},
  ];

  constructor() { }

  ngOnInit() {
  }

}
