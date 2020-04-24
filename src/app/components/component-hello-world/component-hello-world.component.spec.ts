import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentHelloWorldComponent } from './component-hello-world.component';

describe('ComponentHelloWorldComponent', () => {
  let component: ComponentHelloWorldComponent;
  let fixture: ComponentFixture<ComponentHelloWorldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentHelloWorldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentHelloWorldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
