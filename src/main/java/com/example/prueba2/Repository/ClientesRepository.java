package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Cargos;
import com.example.prueba2.Modelo.Clientes;
@Repository
public interface ClientesRepository extends MongoRepository<Clientes, Serializable>{
	
	/*@RestResource(path = "apellido",rel = "apellido")
    public List<Usuario> findByApellidoOrderByNombre(@Param("apellido")String apellido, Pageable pageable);
	*/
	//Busqueda por Nombre de cliente
	@RestResource(path = "nombre",rel = "nombre")
    public List<Clientes> findByNombre(@Param("nombre")String nombre, Pageable pageable);
	
	//Busqueda por Apellido
	@RestResource(path = "apellido", rel = "apellido")
	public List<Clientes> findByApellido(@Param("apellido")String apellido,Pageable pageable);
	
	@RestResource(path = "id",rel = "id")
    public List<Clientes> findById(@Param("id")String id, Pageable pageable);
	/*
	//Borrar cliente por nombre
    @RestResource(path = "borrarPorNombre", rel = "borrarPorNombre")
    public long deleteByNombre(@Param("nombre")String nombre);*/
	
}
 