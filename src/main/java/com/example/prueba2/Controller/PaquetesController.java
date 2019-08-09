package com.example.prueba2.Controller;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.Modelo.Cargos;
import com.example.prueba2.Modelo.Paquetes;
import com.example.prueba2.Repository.PaquetesRepository;

@RestController
@RequestMapping("/paquetes")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PaquetesController {
	
	private PaquetesRepository paquetesRepository;
	
	public PaquetesController(PaquetesRepository paquetesRepository) {
		
		this.paquetesRepository = paquetesRepository;
	}
	
	@GetMapping("/all")
	public List<Paquetes> getAll(){
		List<Paquetes> paquetes = paquetesRepository.findAll();
		return paquetes;
	}
	
	@PostMapping
	public void insertPaquetes(@RequestBody Paquetes paquetes) {
		this.paquetesRepository.insert(paquetes);
	}
	
	@DeleteMapping("/codigo/{id}")
	public void DeletePaquetes(@PathVariable("id")String id) {
		this.paquetesRepository.deleteById(id);
		
	}
}
