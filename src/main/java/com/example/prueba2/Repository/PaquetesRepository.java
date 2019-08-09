package com.example.prueba2.Repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Paquetes;

@Repository
public interface PaquetesRepository extends MongoRepository<Paquetes, Serializable>{

	
	
}
