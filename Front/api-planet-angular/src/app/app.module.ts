import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './component/home/home.component';
import { PlanetComponent } from './component/planet/planet.component';
import { StarComponent } from './component/star/star.component'
import {FormsModule} from '@angular/forms';
import { NavbarComponent } from './component/shared/navbar/navbar.component';
import { StarListComponent } from './component/star-list/star-list.component';
import { PlanetListComponent } from './component/planet-list/planet-list.component'
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PlanetComponent,
    StarComponent,
    NavbarComponent,
    StarListComponent,
    PlanetListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
