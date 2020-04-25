import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentEditServiceComponent } from './component-edit-service.component';

describe('ComponentEditServiceComponent', () => {
  let component: ComponentEditServiceComponent;
  let fixture: ComponentFixture<ComponentEditServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentEditServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentEditServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
