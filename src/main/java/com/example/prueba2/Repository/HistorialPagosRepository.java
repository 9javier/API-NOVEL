package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.prueba2.Modelo.HistorialPagos;


@Repository
public interface HistorialPagosRepository extends CrudRepository<HistorialPagos, Serializable> {
	//Busqueda por Correo
	@RestResource(path = "codigo", rel = "codigo")
	public List<HistorialPagos> findBycodigo(@Param("codigo")int codigo,Pageable pageable);
	
	@RestResource(path="codigo",rel ="codigo")
	public List<HistorialPagos> deleteByCodigo(@Param("codigo")int codigo,Pageable pageable);
	
	@RestResource(path = "nombre", rel = "nombre")
	public List<HistorialPagos> findByNombre(@Param("nombre") String nombre,Pageable pageable);
	
	@RestResource(path = "grupo", rel = "grupo")
	public List<HistorialPagos> findByGrupo(@Param("grupo") String grupo,Pageable pageable);
	
	@RestResource(path= "nombre", rel ="grupo")//Consultar Historial por coincidencia de nombre
	public List<HistorialPagos> findByNombreContaining(@Param("nombre")String nombre);
}


