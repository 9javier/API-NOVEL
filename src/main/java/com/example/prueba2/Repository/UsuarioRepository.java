package com.example.prueba2.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.prueba2.Modelo.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	//Busqueda por Correo
	@RestResource(path = "correo", rel = "correo")
	public List<Usuario> findByCorreo(@Param("correo")String correo,Pageable pageable);
}
