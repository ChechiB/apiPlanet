import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TablaComponent } from './component/tabla/tabla.component';

import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './component/home/home.component';
import { PlanetComponent } from './component/planet/planet.component';
import { StarComponent } from './component/star/star.component'

@NgModule({
  declarations: [
    AppComponent,
    TablaComponent,
    HomeComponent,
    PlanetComponent,
    StarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
