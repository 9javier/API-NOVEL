package com.example.prueba2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.Modelo.Codes;
import com.example.prueba2.Repository.CodesRepository;



@RestController
@RequestMapping("/codes")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CodesController {
	
	@Autowired
	private CodesRepository codesRepository;
	
	
	public CodesController(CodesRepository codesRepository) {
		this.codesRepository = codesRepository;
	}
	
	@GetMapping("/all")
	public @ResponseBody Integer getAll(){
		List<Codes> codes = (List<Codes>) codesRepository.findAll();
		int codigo = (codes.get(0).getCodigo()+1);
		return codigo;
	}
	@PostMapping
	public @ResponseBody String insertCodes(@RequestBody Codes codes) {
		this.codesRepository.save(codes);
		return "code inserted";
	}
	
	@PutMapping("/{codigo}")
	public @ResponseBody String updateCodes(@RequestBody Codes codes) {
		this.codesRepository.save(codes);
		return "code updated";
	}
	
	@GetMapping("/{codigo}")
	public @ResponseBody String updateByCodigo(@PathVariable("codigo")int codigo){
		List<Codes> codes = codesRepository.findByCodigo(codigo, null);
		int code = (codes.get(0).getCodigo()+1);
		int id = codes.get(0).getId();
		Codes  c=new Codes();
		c.setId(id);
		c.setCodigo(code);
		updateCodes(c);
		
		return "code updated";
		
	}
	
	@Transactional
	@DeleteMapping("/{codigo}")//Eliminar codigo
	public void deleteCodigo(@PathVariable("codigo") int codigo) {
		this.codesRepository.deleteByCodigo(codigo,null);
	}
	
	
	
}
