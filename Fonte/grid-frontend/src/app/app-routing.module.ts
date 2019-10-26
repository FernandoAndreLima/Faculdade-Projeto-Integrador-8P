import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfessoresComponent } from './professores/professores.component';
import { DisciplinasComponent } from './disciplinas/disciplinas.component';
import { CursosComponent } from './cursos/cursos.component';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';
import { MenuComponent } from './menu/menu.component';
import { GradeComponent } from './grade/grade.component';


const routes: Routes = [
  { path: 'professores', component: ProfessoresComponent },
  { path: 'disciplinas', component: DisciplinasComponent },
  { path: 'cursos', component: CursosComponent },
  { path: 'menu', component: MenuComponent },
  { path: 'grade', component: GradeComponent },
  { path: '', redirectTo: '/menu' , pathMatch: 'full'},
  { path: '**', component: PaginaNaoEncontradaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
