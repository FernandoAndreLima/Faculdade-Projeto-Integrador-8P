// Angular core
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

// ANgular material
import { MatSliderModule, MatGridListModule, MatMenuModule, MatIconModule, MatOptionModule, MatFormFieldModule, MatSelectModule, MatCardModule} from '@angular/material';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

//Meus importes
import { ProfessoresComponent } from './professores/professores.component';
import { DisciplinasComponent } from './disciplinas/disciplinas.component';
import { CursosComponent } from './cursos/cursos.component';
import { PaginaNaoEncontradaComponent } from './pagina-nao-encontrada/pagina-nao-encontrada.component';
import { MenuComponent } from './menu/menu.component';
import { GradeComponent } from './grade/grade.component';
import { GerarGradeComponent } from './gerar-grade/gerar-grade.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfessoresComponent,
    DisciplinasComponent,
    CursosComponent,
    PaginaNaoEncontradaComponent,
    MenuComponent,
    GradeComponent,
    GerarGradeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    MatSliderModule,
    MatGridListModule,
    FormsModule,
    ReactiveFormsModule,
    MatMenuModule,
    MatIconModule,
    MatOptionModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
