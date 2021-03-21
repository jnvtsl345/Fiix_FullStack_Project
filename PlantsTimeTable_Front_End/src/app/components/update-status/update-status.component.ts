import { Component, OnInit, Input, Output } from '@angular/core';
import { PlantDetails } from 'src/app/models/PlantDetails';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css']
})
export class UpdateStatusComponent implements OnInit {
  @Input() plantDetail:PlantDetails = new PlantDetails;
 
  constructor() {  }

  ngOnInit(): void {
    this.checkWaterStatus(this.plantDetail);
  }
  onIncrement(lastWatered:string){
    this.plantDetail.lastWatered = (parseInt(lastWatered.split(" ")[0]) +1) + " days ago";
    this.checkWaterStatus(this.plantDetail);
  }
  onDecrement(lastWatered:string){
    if(! (parseInt(lastWatered.split(" ")[0]) === 0)){
      this.plantDetail.lastWatered = (parseInt(lastWatered.split(" ")[0])-1) + " days ago";
      this.checkWaterStatus(this.plantDetail);
    }
    
  }
  checkWaterStatus(detail:PlantDetails){
      let lastWateredDays = parseInt(detail.lastWatered.split(" ")[0]);
      let frequency = parseInt(detail.wateringFrequency.split(" ")[1]); 
      if(lastWateredDays - frequency < 0) detail.status="green";
      else if(lastWateredDays - frequency === 0) detail.status ="lightgreen";
     else if(lastWateredDays -frequency >0 && lastWateredDays -frequency <=2 ) detail.status ="yellow";
     else if(lastWateredDays -frequency > 2 ) detail.status ="red";
   
  }
  
}
