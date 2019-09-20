import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { StarService } from 'src/app/services/star.service';
import { Star } from 'src/app/model/star';
@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styles: []
})
export class StarComponent implements OnInit {
  star: Star={
    id: 0,
    name: "",
    density: 0.0,
    planetsSimple: [] = [{
      id:0,
      name:"",
      size:0,
    }]
  }
  
  starDto: any ={
    name: "",
    density: 0.0,
  }

  constructor(private servicioStar:StarService,private activeRoute:ActivatedRoute,private router:Router) { 
    this.activeRoute.params.subscribe((data)=>{
      console.log(data['id'])
      if(data['id'] != "new"){
        this.getOne(data['id']);
      }
    })
  }

  ngOnInit() {    
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
      this.servicioStar.put(id, this.starDto).subscribe((data)=>{
        this.router.navigate(['/']);
      });;
  }

  add(){
    console.log( this.starDto)
    this.servicioStar.post(this.starDto).subscribe((data)=>{
      this.router.navigate(['/']);
    });;
  }

  getOne(id: number){
    this.servicioStar.getOne(id).subscribe((data)=>{
      this.star = data;
      this.starDto.name = data['name'];
      this.starDto.density = data['density'] 
    });
  }


}
