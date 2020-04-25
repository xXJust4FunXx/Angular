import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ComponentHelloWorldComponent } from './components/component-hello-world/component-hello-world.component';
import { ComponentShowServicesComponent } from './components/component-show-services/component-show-services.component';
import { ComponentEditServiceComponent } from './components/component-edit-service/component-edit-service.component';
import { ComponentAddServiceComponent } from './components/component-add-service/component-add-service.component';
import { ComponentMapComponent } from './components/component-map/component-map.component';

@NgModule({
  declarations: [
    AppComponent,
    ComponentHelloWorldComponent,
    ComponentShowServicesComponent,
    ComponentEditServiceComponent,
    ComponentAddServiceComponent,
    ComponentMapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
