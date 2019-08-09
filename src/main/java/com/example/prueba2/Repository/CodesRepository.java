package com.example.prueba2.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.example.prueba2.Modelo.Codes;

@Repository
public interface CodesRepository extends MongoRepository<Codes,Serializable> {
	
	@RestResource(path="codigo",rel ="codigo")
	public List<Codes> findByCodigo(@Param("codigo")int codigo,Pageable pageable);
	
	@RestResource(path="codigo",rel ="codigo")
	public List<Codes> deleteByCodigo(@Param("codigo")int codigo,Pageable pageable);
	
}
