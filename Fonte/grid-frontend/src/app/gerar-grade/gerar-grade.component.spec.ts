import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GerarGradeComponent } from './gerar-grade.component';

describe('GerarGradeComponent', () => {
  let component: GerarGradeComponent;
  let fixture: ComponentFixture<GerarGradeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GerarGradeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GerarGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
