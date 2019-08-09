package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Usuario;
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Serializable>{
	
	//Busqueda por Correo
			@RestResource(path = "correo", rel = "correo")
			public List<Usuario> findByCorreo(@Param("correo")String correo,Pageable pageable);
		
}
