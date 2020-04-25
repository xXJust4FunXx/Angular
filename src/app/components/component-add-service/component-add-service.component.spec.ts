import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentAddServiceComponent } from './component-add-service.component';

describe('ComponentAddServiceComponent', () => {
  let component: ComponentAddServiceComponent;
  let fixture: ComponentFixture<ComponentAddServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentAddServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentAddServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
