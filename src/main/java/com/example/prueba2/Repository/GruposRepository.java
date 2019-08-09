package com.example.prueba2.Repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Grupos;
@Repository
public interface GruposRepository extends MongoRepository<Grupos, Serializable>{

}
