package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.Cargos;


@Repository
public interface CargosRepository extends CrudRepository<Cargos, Serializable> {
	@RestResource(path = "nombre", rel = "nombre")
	public List<Cargos> findByNombre(@Param("nombre") String nombre,Pageable pageable);
	
	@RestResource(path="codigo",rel ="codigo")
	public List<Cargos> findByCodigo(@Param("codigo")int codigo,Pageable pageable);
	
	@RestResource(path="codigo",rel ="codigo")
	public List<Cargos> deleteByCodigo(@Param("codigo")int codigo,Pageable pageable);
	
	@RestResource(path = "grupo", rel = "grupo")
	public List<Cargos> findByGrupo(@Param("grupo") String grupo,Pageable pageable);
	
	@RestResource(path = "nombre", rel = "nombre")
	public List<Cargos> findByNombreContaining(@Param("nombre") String nombre,Pageable pageable);
	
}
