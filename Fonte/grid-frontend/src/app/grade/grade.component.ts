import { Component, OnInit } from '@angular/core';

export interface ItemTela {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-grade',
  templateUrl: './grade.component.html',
  styleUrls: ['./grade.component.css']
})
export class GradeComponent implements OnInit {

  itensTela: ItemTela[] = [
    {value: '/grade/gerar', viewValue: 'Gerar grade'}
  ];

  constructor() { }

  ngOnInit() {
  }

}
