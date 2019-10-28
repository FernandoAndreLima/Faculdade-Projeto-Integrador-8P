import { Component, OnInit } from '@angular/core';

export interface Curso {
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
    {value: 'ADM', viewValue: 'Bacharelado em administração'}
  ]

  constructor() { }

  ngOnInit() {
  }

}
