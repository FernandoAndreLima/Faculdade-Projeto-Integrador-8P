import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';
import { Curso } from 'src/app/model/curso';

// export interface Curso {
//   value: string;
//   viewValue: string;
// }

export interface Semestre {
  value: string;
  viewValue: string;
}

export interface Periodo {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-gerar',
  templateUrl: './gerar.component.html',
  styleUrls: ['./gerar.component.css']
})
export class GerarComponent implements OnInit {

  cursos: Curso[] = [
    {_id: '1', nome: 'Bacharelado em sistemas da informação'},
    {_id: '2', nome: 'Bacharelado em administração'},
    {_id: '3', nome: 'Engenharia de Produção'}
  ]

  semestres: Semestre[] = [
    {value: 'primeiro', viewValue: 'Primeiro Semestre'},
    {value: 'segundo', viewValue: 'Segundo Semestre'}
  ]

  periodosPrimeiroSemestre: Periodo[] = [
    {value: 'primeiro', viewValue: 'Primeiro Período'},
    {value: 'terceiro', viewValue: 'Terceiro Período'},
    {value: 'quinto', viewValue: 'Quinto Período'},
    {value: 'setimo', viewValue: 'Sétimo Período'}
  ]
  periodosSegundoSemestre: Periodo[] = [
    {value: 'segundo', viewValue: 'Segundo Período'},
    {value: 'quarto', viewValue: 'Quarto Período'},
    {value: 'sexto', viewValue: 'Sexto Período'},
    {value: 'oitavo', viewValue: 'Oitavo Período'}
  ]

  constructor(private _api: ApiService) { }

  ngOnInit() {
  }

}