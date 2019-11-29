package com.example.prueba2.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.prueba2.Modelo.Sesiones;

public interface SesionesRepository extends CrudRepository<Sesiones,Integer> {
	
	@RestResource(path = "idusuario",rel = "idusuario")
    public List<Sesiones> findByIdusuario(@Param("idusuario")int id, Pageable pageable);
	
	@RestResource(path ="idusuario",rel="idusuario")
	public List<Sesiones> deleteByIdusuario(@Param("idusuario") int idusuario);
}
