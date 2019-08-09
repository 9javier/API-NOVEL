package com.example.prueba2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.Modelo.Sesiones;
import com.example.prueba2.Modelo.Usuario;
import com.example.prueba2.Repository.SesionesRepository;
import com.example.prueba2.Repository.UsuarioRepository;
import com.mongodb.util.JSON;


@RestController
@RequestMapping("/sesiones")
public class SesionesController {
	
	private SesionesRepository sesionesRepository;
	
	public SesionesController(SesionesRepository sesionesRepository) {
		this.sesionesRepository = sesionesRepository;
	}
	@GetMapping("/all")//obtener todos los tokens de sesiones de los usuarios
	public List<Sesiones> getTokens(){
		
	List<Sesiones> sesiones= this.sesionesRepository.findAll();
			
	return sesiones;
	
	}
	
	/*@GetMapping("/token/{id}")//Consultar token por ID
	public String getById(@PathVariable("id")String id) {
		String res="{'sesion':0}";
		Optional<Sesiones> sesion = this.sesionesRepository.findById(id);
		if(sesion.isPresent()) {
			String idToken = sesion.get().getId().toString();
			if(id.equals(idToken)) {
				System.out.print("el token coincide"+idToken);
				res="{'sesion':1}";
			}
		}
		
		System.out.println("id puesto"+id);
		
		return res;
	}*/
	
	@GetMapping("/token/{id}")//Consultar token por ID
	public Optional<Sesiones> getById(@PathVariable("id")String id) {
		Optional<Sesiones> sesion = this.sesionesRepository.findById(id);
		
		return sesion;
	}
	
	@GetMapping("/token/usuario/{idusuario}")//Consultar token por ID del usuario
	public List<Sesiones> getByIdUsario(@PathVariable("idusuario")String idusuario) {
		
		List<Sesiones> sesion = this.sesionesRepository.findByIdusuario(idusuario, null);
		return sesion;
	}
	
	@PostMapping//Insertar token
	public String  insertToken(@RequestBody Sesiones sesiones) {
		this.sesionesRepository.insert(sesiones);
		/*List<String> response = null;
		response.add(sesiones.toString());*/
		
		String objeto = "{'id':'"+sesiones.getId()+"'}";
		
		return objeto;
	}
	
	@PutMapping//Actualizar token
	public void updateToken(@RequestBody Sesiones sesiones) {
		this.sesionesRepository.save(sesiones);
	}
	
	@DeleteMapping("/{id}")//Borrar token
	public String deleteToken(@PathVariable("id")String id) {
	this.sesionesRepository.deleteById(id);
	String response ="{'status':1}";//si el token fue eliminado correctamente devuelve un 1
		
	return response;
	}
	
	
	
	

	
}
