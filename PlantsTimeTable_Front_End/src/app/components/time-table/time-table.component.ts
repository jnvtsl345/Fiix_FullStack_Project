import { Component, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Observable } from 'rxjs';
import { PlantDetails } from '../../models/PlantDetails';
import { TimeTableService } from '../../services/time-table.service';
@Component({
  selector: 'app-time-table',
  templateUrl: './time-table.component.html',
  styleUrls: ['./time-table.component.css']
})
export class TimeTableComponent implements OnInit {
  plantDetails:PlantDetails[] =[]; //This list holds details for all the plants|| PlantDetails is my model
  alert:boolean =false;
  constructor(private timeTableService:TimeTableService) { }
// On initialization making a call to backend and fetching data. State of plantDetails will be updated
  ngOnInit(){
    this.timeTableService.getTimeTable().subscribe(plantDetails => {
      this.plantDetails =plantDetails;
    
    })
  }
  //This method handels the post call made to the backend to upload data 
  onUpload(){ 
    this.timeTableService.postTimeTable(this.plantDetails);
    this.alert = true;
  }
  onCloseMessageClick(){
  this.alert=false;
}

}
