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

import com.example.prueba2.Modelo.Paquetes;
import com.example.prueba2.Repository.PaquetesRepository;


@RestController
@RequestMapping("/paquetes")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PaquetesController {
	@Autowired
	private PaquetesRepository paquetesRepository;
	
	public PaquetesController(PaquetesRepository paquetesRepository) {
		
		this.paquetesRepository = paquetesRepository;
	}
	
	@GetMapping("/all")
	public @ResponseBody List<Paquetes> getAll(){
		List<Paquetes> paquetes = (List<Paquetes>) paquetesRepository.findAll();
		return paquetes;
	}
	
	@PostMapping
	public @ResponseBody String insertPaquetes(@RequestBody Paquetes paquetes) {
		this.paquetesRepository.save(paquetes);
		return "Paquete inserted";
	}
	@Transactional
	@DeleteMapping("/codigo/{id}")
	public @ResponseBody String DeletePaquetes(@PathVariable("id")int id) {
		this.paquetesRepository.deleteById(id);
		return "grupo deleted";
	}
	
	@GetMapping("/name/{descripcion}")
	public @ResponseBody List<Paquetes> getByName(@PathVariable("descripcion")String descripcion){
		List<Paquetes> paquetes = paquetesRepository.findByDescripcion(descripcion, null);
		return paquetes;
	}
	
	@PutMapping 
	private @ResponseBody String updatePaquetesByName(@RequestBody Paquetes paquetes){
		this.paquetesRepository.save(paquetes);
		return "grupo updated";
	}
}
