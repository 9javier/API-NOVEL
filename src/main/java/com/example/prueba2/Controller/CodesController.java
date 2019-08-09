package com.example.prueba2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.prueba2.Modelo.Codes;
import com.example.prueba2.Repository.CodesRepository;


@RestController
@RequestMapping("/codes")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CodesController {
	
	private CodesRepository codesRepository;
	
	
	public CodesController(CodesRepository codesRepository) {
		this.codesRepository = codesRepository;
	}
	
	@GetMapping("/all")
	public Integer getAll(){
		List<Codes> codes = codesRepository.findAll();
		int codigo = (codes.get(0).getCodigo()+1);
		return codigo;
	}
	@PostMapping
	public void insertCodes(@RequestBody Codes codes) {
		this.codesRepository.insert(codes);
	}
	
	@PutMapping("/{codigo}")
	public void updateCodes(@RequestBody Codes codes) {
		this.codesRepository.save(codes);
	}
	
	@GetMapping("/{codigo}")
	public void updateByCodigo(@PathVariable("codigo")int codigo){
		List<Codes> codes = codesRepository.findByCodigo(codigo, null);
		int code = (codes.get(0).getCodigo()+1);
		String id = codes.get(0).getId().toString();
		Codes  c=new Codes();
		c.setId(id);
		c.setCodigo(code);
		updateCodes(c);
		
	}
	

	
	@DeleteMapping("/{codigo}")//Eliminar codigo
	public void deleteCodigo(@PathVariable("codigo") int codigo) {
		this.codesRepository.deleteByCodigo(codigo,null);
	}
	
	
	
}
