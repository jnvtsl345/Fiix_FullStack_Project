package com.example.demo.controller;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.PlantTimeTable;


@RestController
public class PlantTimeTableController {
	@Autowired
	LoadPlantTimeTable plantTimeTable;
 
  @CrossOrigin("http://localhost:4200")
  @GetMapping("/getTable")	
  public Iterable<PlantTimeTable> fetchData() {
	  System.out.println("Got a request!");
	  return plantTimeTable.getDataToDatabase();
  }
   
   @CrossOrigin("http://localhost:4200")
   @PostMapping("/saveTable")	
   public String saveData(@RequestBody String timeTable) throws ParseException {
        JSONParser parser = new JSONParser();
		Object obj = parser.parse(timeTable);
		plantTimeTable.SaveDataToDatabase(obj);
		return "Uploaded Successfully!!";
	  }
}
