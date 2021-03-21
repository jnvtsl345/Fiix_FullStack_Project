package com.example.demo.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.PlantTimeTable;

public interface PlantsRepo extends CrudRepository<PlantTimeTable,String> {

}
