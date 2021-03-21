package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlantTimeTable {

 @Id	
 private String PlantName;
 private String LastWatered;
 private String WateringFrequency;

public String getPlantName() {
	return PlantName;
}
public void setPlantName(String object) {
	PlantName = object;
}
public String getLastWatered() {
	return LastWatered;
}
public void setLastWatered(String lastWatered) {
	LastWatered = lastWatered;
}
public String getWateringFrequency() {
	return WateringFrequency;
}
public void setWateringFrequency(String wateringFrequency) {
	WateringFrequency = wateringFrequency;
}
}
