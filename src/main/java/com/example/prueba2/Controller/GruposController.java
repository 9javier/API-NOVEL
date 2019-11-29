package com.example.prueba2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.example.prueba2.Modelo.Grupos;
import com.example.prueba2.Repository.GruposRepository;



@Controller
@RequestMapping("/grupos")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GruposController {
	
	@Autowired
	private GruposRepository gruposRepository;
	
	public GruposController(GruposRepository gruposRepository) {
		this.gruposRepository = gruposRepository;
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Grupos> getAll(){
		Iterable<Grupos> grupos = gruposRepository.findAll();
		return grupos;
	}
	
	@PostMapping
	public @ResponseBody String insertGrupos(@RequestBody Grupos grupos) {
		this.gruposRepository.save(grupos);
		return "grupo inserted";
	}
	
	@Transactional
	@DeleteMapping("/codigo/{id}")
	public @ResponseBody String DeleteGrupos(@PathVariable("id")int id) {
		this.gruposRepository.deleteById(id);
		return "Grupo deleted";
	}
	
	@PutMapping
	public @ResponseBody String updateGrupos(@RequestBody Grupos grupos) {
		this.gruposRepository.save(grupos);
		return "grupos updated";
	}
	
}
