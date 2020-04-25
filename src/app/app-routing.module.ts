import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ComponentShowServicesComponent} from './components/component-show-services/component-show-services.component';
import {ComponentHelloWorldComponent} from './components/component-hello-world/component-hello-world.component';
import {ComponentAddServiceComponent} from './components/component-add-service/component-add-service.component';
import {ComponentMapComponent} from './components/component-map/component-map.component';
import {ComponentEditServiceComponent} from './components/component-edit-service/component-edit-service.component';


const routes: Routes = [
  {path: 'hello-world', component: ComponentHelloWorldComponent},
  {path: 'show-services', component: ComponentShowServicesComponent},
  {path: 'show-map', component: ComponentMapComponent},
  {path: 'new-service', component: ComponentAddServiceComponent},
  {path: 'edit-service', component: ComponentEditServiceComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
