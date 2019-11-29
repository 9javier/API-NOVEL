package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Paquetes;


@Repository
public interface PaquetesRepository extends CrudRepository<Paquetes, Serializable>{

	@RestResource(path = "descripcion", rel = "descripcion")
	public List<Paquetes> findByDescripcion(@Param("descripcion") String descripcion,Pageable pageable);
	
}
