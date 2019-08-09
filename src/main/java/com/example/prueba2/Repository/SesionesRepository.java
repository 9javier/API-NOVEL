package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Clientes;
import com.example.prueba2.Modelo.Sesiones;
import com.example.prueba2.Modelo.Usuario;
@Repository
public interface SesionesRepository extends MongoRepository<Sesiones, Serializable>{

/*	//Consultar token por ID del usuario
	@RestResource(path = "id_usuario", rel ="id_usuario")
	public List<Sesiones> findById(@Param("id_usuario")String id_usuario,Pageable pageable);
	*/
	@RestResource(path = "idusuario",rel = "idusuario")
    public List<Sesiones> findByIdusuario(@Param("idusuario")String id, Pageable pageable);
}
