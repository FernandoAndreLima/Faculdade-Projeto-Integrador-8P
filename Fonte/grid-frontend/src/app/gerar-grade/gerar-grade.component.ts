import { Component, OnInit } from '@angular/core';

export interface Curso {
  value: string;
  viewValue: string;
}

export interface Semestre {
  value: string;
  viewValue: string;
}

export interface Periodo {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-gerar-grade',
  templateUrl: './gerar-grade.component.html',
  styleUrls: ['./gerar-grade.component.css']
})
export class GerarGradeComponent implements OnInit {

  cursos: Curso[] = [
    {value: 'BSI', viewValue: 'Bacharelado em sistemas da informação'},
    {value: 'ADM', viewValue: 'Bacharelado em administração'},
    {value: 'ENP', viewValue: 'Engenharia de Produção'}
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

  constructor() { }

  ngOnInit() {
  }

}
