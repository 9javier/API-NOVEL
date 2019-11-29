package com.example.prueba2.Repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Grupos;

@Repository
public interface GruposRepository extends CrudRepository<Grupos, Serializable>{

}
