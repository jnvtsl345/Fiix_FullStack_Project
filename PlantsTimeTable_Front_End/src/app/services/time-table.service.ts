import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PlantDetails } from '../models/PlantDetails';
@Injectable({
  providedIn: 'root'
})
export class TimeTableService {
  timeTableUrl:string = 'http://localhost:8080/getTable';
  saveTimeTableUrl:string = 'http://localhost:8080/saveTable';
  constructor(private http:HttpClient) { }
  getTimeTable():Observable<PlantDetails[]> {
      return this.http.get<PlantDetails[]>(this.timeTableUrl);
  }
  postTimeTable(plantSchedule:PlantDetails[]){
    let message ="";
    this.http.post("http://localhost:8080/saveTable",JSON.stringify(plantSchedule)).toPromise().then(data => {
      console.log(data);
    });
 
  }
}
