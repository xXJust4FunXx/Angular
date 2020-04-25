import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentShowServicesComponent } from './component-show-services.component';

describe('ComponentShowServicesComponent', () => {
  let component: ComponentShowServicesComponent;
  let fixture: ComponentFixture<ComponentShowServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentShowServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentShowServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
