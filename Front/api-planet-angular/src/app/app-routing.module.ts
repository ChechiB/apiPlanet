import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TablaComponent } from './component/tabla/tabla.component';
import { PlanetComponent } from './component/planet/planet.component';
import { StarComponent } from './component/star/star.component';



const routes: Routes = [ // El orden determina la precedencia. El primer matcheo es el que tomará
  {path: 'planet/new', component: PlanetComponent},
  {path: 'planet/:id', component: TablaComponent},
  {path: '', component: TablaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
