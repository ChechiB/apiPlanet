import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlanetComponent } from './component/planet/planet.component';
import { StarComponent } from './component/star/star.component';
import { PlanetListComponent } from './component/planet-list/planet-list.component';
import { StarListComponent } from './component/star-list/star-list.component';
import { HomeComponent } from './component/home/home.component';



const routes: Routes = [ // El orden determina la precedencia. El primer matcheo es el que tomará
  {path: 'planet/:id', component: PlanetComponent},
  //{path: 'planet/new', component: PlanetComponent},
  {path: 'star/:id', component: StarComponent},
  {path: 'planets', component: PlanetListComponent},
  {path: 'stars', component: StarListComponent},
  {path: 'home', component: HomeComponent},
  {path: '', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
