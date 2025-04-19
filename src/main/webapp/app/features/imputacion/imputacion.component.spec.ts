import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImputacionComponent } from './imputacion.component';

describe('ImputacionComponent', () => {
  let component: ImputacionComponent;
  let fixture: ComponentFixture<ImputacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImputacionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImputacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
