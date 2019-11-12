import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';
import { GradeComponent } from './grade/grade.component';
import { GerarComponent } from './gerar/gerar.component';


const routes: Routes = [
  { path: 'grade', component: GradeComponent },
  { path: 'construir', component: GerarComponent },
  { path: '', redirectTo: '/' , pathMatch: 'full'},
  { path: '**', component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
