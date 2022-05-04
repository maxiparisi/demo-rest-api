package com.gire.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gire.poc.model.Persona;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String>{
	

}
