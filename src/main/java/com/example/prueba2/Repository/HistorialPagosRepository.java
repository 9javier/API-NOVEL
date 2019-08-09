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
import com.example.prueba2.Modelo.HistorialPagos;


@Repository
public interface HistorialPagosRepository extends MongoRepository<HistorialPagos, Serializable> {
	//Busqueda por Correo
	@RestResource(path = "codigo", rel = "codigo")
	public List<HistorialPagos> findBycodigo(@Param("codigo")int codigo,Pageable pageable);
	
	//@RestResource(path="codigo",rel ="codigo")
	//public List<Cargos> findByCodigo(@Param("codigo")String codigo,Pageable pageable);
}


