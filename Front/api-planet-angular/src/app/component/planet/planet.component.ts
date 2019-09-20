import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-planet',
  templateUrl: './planet.component.html',
  styles: []
})
export class PlanetComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log("planet/new");
  }

}
