import { Component, OnInit } from '@angular/core';
import { PlanetService } from 'src/app/services/planet.service';
import { Planet } from 'src/app/model/planet';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planet-list',
  templateUrl: './planet-list.component.html',
  styles: []
})
export class PlanetListComponent implements OnInit {
  planets: Planet[] = [];

  constructor(private servicio:PlanetService, private router:Router) { 
    this.getAll();
  }

  ngOnInit() {
  }

  getAll(){
    this.servicio.getAll().subscribe((data)=>{
      this.planets = data;
      console.log(this.planets);

    });
  }

  delete(id: number){
    this.servicio.delete(id).subscribe(()=>{
      console.log("Deleted successfully");
      window.location.reload();
    },
    ()=>{
      console.log("Failed delete");
    });
  }

  update(id:number){
    this.router.navigate(["planet/"+id]);
  }

  add(){
    console.log("planet/new");
    this.router.navigate( ['planet/new'] );
    //this.router.navigate(["/new"]);
  }
}
