package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.json.simple.parser.JSONParser;
import com.example.demo.controller.LoadPlantTimeTable;
import java.io.*;
@SpringBootApplication
public class PlantTimeTable1Application {
	
	public static void main(String[] args)  {
		ConfigurableApplicationContext context=   SpringApplication.run(PlantTimeTable1Application.class, args);
		LoadPlantTimeTable plantTimeTable = context.getBean(LoadPlantTimeTable.class);
		JSONParser parser = new JSONParser();
		Object obj;
		try {
			obj = parser.parse(new FileReader("src/main/resources/PlantsWateringSchedule.json"));
			plantTimeTable.LoadDataToDatabase(obj);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
