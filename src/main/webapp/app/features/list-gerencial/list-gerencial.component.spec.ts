import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListGerencialComponent } from './list-gerencial.component';

describe('ListGerencialComponent', () => {
  let component: ListGerencialComponent;
  let fixture: ComponentFixture<ListGerencialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListGerencialComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListGerencialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
