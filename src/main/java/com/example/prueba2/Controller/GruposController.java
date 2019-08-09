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

import com.example.prueba2.Modelo.Grupos;
import com.example.prueba2.Modelo.Paquetes;
import com.example.prueba2.Repository.GruposRepository;


@RestController
@RequestMapping("/grupos")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GruposController {

	private GruposRepository gruposRepository;
	
	public GruposController(GruposRepository gruposRepository) {
		this.gruposRepository = gruposRepository;
	}
	
	@GetMapping("/all")
	public List<Grupos> getAll(){
		List<Grupos> grupos = gruposRepository.findAll();
		return grupos;
	}
	
	@PostMapping
	public void insertGrupos(@RequestBody Grupos grupos) {
		this.gruposRepository.insert(grupos);
	}
	
	@DeleteMapping("/codigo/{id}")
	public void DeleteGrupos(@PathVariable("id")String id) {
		this.gruposRepository.deleteById(id);
		
	}
	
	
}
