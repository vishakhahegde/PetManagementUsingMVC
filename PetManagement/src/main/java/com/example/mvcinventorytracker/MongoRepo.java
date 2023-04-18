package com.example.mvcinventorytracker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo extends MongoRepository <pet,String>{
	public List<pet> findAll();
	public void deleteByName(String name);

}
