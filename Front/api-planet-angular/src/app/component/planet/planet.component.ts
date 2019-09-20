import { Component, OnInit } from '@angular/core';
import { StarService } from 'src/app/services/star.service';
import { Star } from 'src/app/model/star';
import { Planet } from 'src/app/model/planet';
import { PlanetService } from 'src/app/services/planet.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-planet',
  templateUrl: './planet.component.html',
  styles: []
})
export class PlanetComponent implements OnInit {
  stars: Star[] = [];

  planet: Planet = {
      id: 0,
      name: "",
      size: 0,
      star: {
        id: 0,
        name: "",
        density: 0,
        planets: null
      },
    }

  star: Star;

  constructor(private servicioStar:StarService,private servicioPlanet:PlanetService,
    private activeRoute:ActivatedRoute,private router:Router) { 
    this.activeRoute.params.subscribe((data)=>{
      console.log(data['id'])
      if(data['id'] != "new"){
        this.getOne(data['id']);
      }
    })
  }

  ngOnInit() {    
    this.servicioStar.getAll().subscribe((data)=>{
      for (let index = 0; index < data.length; index++) {
        const element:any = data[index];
        this.stars.push(element);
      }
    });

  }

  save(){
    this.activeRoute.params.subscribe((data)=>{
      if(data['id'] == "new"){
        this.add();
      }else{
        this.update(data['id']);
      }
    })
  }

  update(id: number){
      this.servicioPlanet.put(id, this.planet).subscribe((data)=>{
        this.router.navigate(['/planets/']);
      });;
  }

  add(){
    this.servicioPlanet.post(this.planet).subscribe((data)=>{
      this.router.navigate(['/planets/']);
    });;
  }

  getOne(id: number){
    this.servicioPlanet.getOne(id).subscribe((data)=>{
      this.planet = data;
    });
  }

}
