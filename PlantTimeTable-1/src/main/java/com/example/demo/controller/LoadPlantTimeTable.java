package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.example.demo.dao.PlantsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.demo.model.PlantTimeTable;

@Component
public class LoadPlantTimeTable {
	@Autowired	
	PlantsRepo repo;
	public void LoadDataToDatabase(Object obj) {	
		JSONArray array =(JSONArray)obj;
		PlantTimeTable plantDetails = new PlantTimeTable();
		for(int i=0;i<array.size();i++) {
			JSONObject plantDetail = (JSONObject) array.get(i);
			plantDetails.setPlantName(plantDetail.get("Name").toString());
			plantDetails.setLastWatered(plantDetail.get("Last Watered Date").toString());
			plantDetails.setWateringFrequency(plantDetail.get("Watering frequency").toString());
			repo.save(plantDetails);
		}
		
	}
	public void SaveDataToDatabase(Object obj) {	
		JSONArray array =(JSONArray)obj;
		PlantTimeTable plantDetails = new PlantTimeTable();
		for(int i=0;i<array.size();i++) {
			JSONObject plantDetail = (JSONObject) array.get(i);
			plantDetails.setPlantName(plantDetail.get("plantName").toString());
			plantDetails.setLastWatered(plantDetail.get("lastWatered").toString());
			plantDetails.setWateringFrequency(plantDetail.get("wateringFrequency").toString());
			repo.save(plantDetails);
		}
		
	}
	public Iterable<PlantTimeTable> getDataToDatabase() {	
		return repo.findAll();
		
	}
}
