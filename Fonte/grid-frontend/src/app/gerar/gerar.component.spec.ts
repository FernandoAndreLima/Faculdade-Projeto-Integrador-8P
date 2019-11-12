import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GerarComponent } from './gerar.component';

describe('ConstruirComponent', () => {
  let component: GerarComponent;
  let fixture: ComponentFixture<GerarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GerarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GerarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
