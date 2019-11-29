package com.example.prueba2.Controller;

import java.util.List;
import java.util.Optional;

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

import com.example.prueba2.Modelo.Sesiones;
import com.example.prueba2.Repository.SesionesRepository;

@Controller
@RequestMapping(path="/sesiones")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SesionesController {

	@Autowired
	private SesionesRepository sesionesRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Sesiones> getTokens(){
		
	Iterable<Sesiones> sesiones = this.sesionesRepository.findAll();
	return sesiones;
	}
	
	@GetMapping("/token/{id}")//Consultar token por ID
	public @ResponseBody Optional<Sesiones> getById(@PathVariable("id")int id) {
		Optional<Sesiones> sesion = this.sesionesRepository.findById(id);
		
		return sesion;
	}
	
	@GetMapping("/token/usuario/{idusuario}")//Consultar token por ID del usuario
	public @ResponseBody List<Sesiones> getByIdUsario(@PathVariable("idusuario")int idusuario) {
		
		List<Sesiones> sesion = this.sesionesRepository.findByIdusuario(idusuario, null);
		return sesion;
	}
	
	@PostMapping//Insertar token
	public @ResponseBody String  insertToken(@RequestBody Sesiones sesiones) {
		this.sesionesRepository.save(sesiones);
		/*List<String> response = null;
		response.add(sesiones.toString());*/
		
		String objeto = "{'id':'"+sesiones.getIdusuario()+"'}";
		
		return objeto;
	}
	
	@PutMapping//Actualizar token
	public @ResponseBody String updateToken(@RequestBody Sesiones sesiones) {
		this.sesionesRepository.save(sesiones);
		return "token updated";
	}
	
	@Transactional
	@DeleteMapping("/{id}")//Borrar token
	public @ResponseBody String deleteToken(@PathVariable("id")int id) {
	this.sesionesRepository.deleteById(id);
	String response ="{'status':1}";//si el token fue eliminado correctamente devuelve un 1
		
	return response;
	}
	@Transactional
	@DeleteMapping("/delete/id/{idusuario}")//Borrar token
	public @ResponseBody String deleteByIdUsuario(@PathVariable("idusuario")int idusuario) {
	this.sesionesRepository.deleteByIdusuario(idusuario);
	String response ="{'status':1}";//si el token fue eliminado correctamente devuelve un 1
		
	return response;
	}
	
}
