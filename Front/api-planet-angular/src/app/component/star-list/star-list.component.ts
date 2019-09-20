import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/model/star';
import { Router } from '@angular/router';
import { StarService } from 'src/app/services/star.service';

@Component({
  selector: 'app-star-list',
  templateUrl: './star-list.component.html',
  styles: []
})
export class StarListComponent implements OnInit {

  stars: Star[] = [];

  constructor(private servicio:StarService, private router:Router) { 
    this.getAll();
  }

  ngOnInit() {
  }

  getAll(){
    this.servicio.getAll().subscribe((data)=>{
      this.stars = data;
      console.log(this.stars);

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
    this.router.navigate(["star/"+id]);
  }

  add(){
    this.router.navigate( ['star/new'] );
    //this.router.navigate(["/new"]);
  }

}
