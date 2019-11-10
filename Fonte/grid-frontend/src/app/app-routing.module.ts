import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';
import { GradeComponent } from './grade/grade.component';
import { ConstruirComponent } from './grade/construir/construir.component';


const routes: Routes = [
  { path: 'grade', component: GradeComponent },
  { path: 'grade/construir', component: ConstruirComponent },
  { path: '', redirectTo: '/' , pathMatch: 'full'},
  { path: '**', component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
