package com.example.prueba2.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.prueba2.Modelo.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes,Integer> {

	@RestResource(path = "nombre",rel = "nombre")
    public List<Clientes> findByNombre(@Param("nombre")String nombre, Pageable pageable);
	
	@RestResource(path = "apellido", rel = "apellido")
	public List<Clientes> findByApellido(@Param("apellido")String apellido,Pageable pageable);
	
	
}
