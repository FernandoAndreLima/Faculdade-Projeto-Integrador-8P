import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConstruirComponent } from './construir.component';

describe('ConstruirComponent', () => {
  let component: ConstruirComponent;
  let fixture: ComponentFixture<ConstruirComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConstruirComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConstruirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
