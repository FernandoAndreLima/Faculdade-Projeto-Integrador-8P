import { Component, OnInit } from '@angular/core';
import { Tile } from 'src/app/model/tile';

@Component({
  selector: 'app-pagina-nao-encontrada',
  templateUrl: './pagina-nao-encontrada.component.html',
  styleUrls: ['./pagina-nao-encontrada.component.css']
})
export class PaginaNaoEncontradaComponent implements OnInit {

  tiles: Tile[] = [
    {text: 'ERRO 404 Página não encontrada', cols: 12, rows: 1, color: 'PaleGoldenrod'},
  ];

  constructor() { }

  ngOnInit() {
  }

}
