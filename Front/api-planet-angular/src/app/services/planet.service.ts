import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Planet } from '../model/planet';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlanetService {
   _url: string = 'http://localhost:9000/api/v1/planets/';

  constructor(private http:HttpClient) { }

  getAll():Observable<Planet[]>{
    return this.http.get<Planet[]>(this._url);
  }

  getOne(id:number){
    this.http.get(this._url+id);

  }

  post(planet: Planet){
    this.http.post(this._url, planet)
  }

  put(id:number,planet:Planet){
    this.http.post(this._url+id, planet)
  }

  delete(id:number): Observable<any>{
    return this.http.delete(this._url+id);
  }
}
