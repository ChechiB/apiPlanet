import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Star } from '../model/star';

@Injectable({
  providedIn: 'root'
})
export class StarService {

  _url: string = 'http://localhost:9000/api/v1/planets/';

  constructor(private http:HttpClient) { }

  getAll(){
    this.http.get(this._url);
  }

  getOne(id:number){
    this.http.get(this._url+id);

  }

  post(star: Star){
    this.http.post(this._url, star)
  }

  put(id:number,star:Star){
    this.http.post(this._url+id, star)
  }

  delete(id:number){
    this.http.delete(this._url+id);
  }
}
