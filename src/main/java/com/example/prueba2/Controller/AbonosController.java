package com.example.prueba2.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.Modelo.Abonos;
import com.example.prueba2.Repository.AbonosRepository;

@RestController
@RequestMapping("/abonos")
public class AbonosController {

	private AbonosRepository abonosRepository;
	
	public AbonosController(AbonosRepository abonosRepository ) {
		this.abonosRepository = abonosRepository;
		
	}
	
	@GetMapping("/all")
	public List<Abonos> getAll(){
		List<Abonos> abonos = abonosRepository.findAll();
		return abonos;
	}
	
	@GetMapping("/codigo/{codigo}")
	public List<Abonos> getAbonosByCodigo(@PathVariable("codigo")int codigo){
		List<Abonos> abonos = abonosRepository.findByCodigo(codigo, null);
		return abonos;
	}
	
	@PostMapping
	public void insertGrupos(@RequestBody Abonos grupos) {
		this.abonosRepository.insert(grupos);
	}
	
	@DeleteMapping("/codigo/{codigo}")
	public void DeleteGrupos(@PathVariable("codigo")int codigo) {
		this.abonosRepository.deleteByCodigo(codigo, null);
		
	}
	
}
