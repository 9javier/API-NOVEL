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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.prueba2.Modelo.Users;
import com.example.prueba2.Repository.UsersRepository;

@Controller
@RequestMapping(path="/users")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsersController {
	
	@Autowired 
	private UsersRepository usersRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Users> getAllUsers(@RequestHeader(value="Apikey") String token) {
		
		Iterable<Users>  usuarios = usersRepository.findAll();
		return usuarios;
		
	}
	
	/*Obtner usuario ById*/	
	@GetMapping("/id/{id}")
	public @ResponseBody Optional<Users> getById(@PathVariable("id")int id){
	
		Optional<Users> usuario = usersRepository.findById(id);
		return usuario;
	}
	
	
	@PostMapping
	public @ResponseBody String insertarUsuario(@RequestBody  Users usuario) {
		usersRepository.save(usuario);
		List<Users> us = getUsuarioCliente(usuario.getCorreo());
		String objeto = "{'id':'"+us.get(0).getId()+"'}";//si se inserto correctamente retornamos el id del registro.
		return objeto;
	}
	
	@PutMapping//Actualizar usuario
	public @ResponseBody String updatUsuario(@RequestBody Users usuario) {
		this.usersRepository.save(usuario);
		return "user updated";
	}
	
	@Transactional
	@DeleteMapping("/{id}")//Eliminar Usuario
	public  @ResponseBody String deleteUsuario(@PathVariable("id") int id) {
		this.usersRepository.deleteById(id);
		
		return "user deleted";
	}
	
	
	@GetMapping("/correo/{correo}")//Consultar el usuario por correo
	public @ResponseBody List<Users> getUsuarioCliente(@PathVariable("correo") String correo){
		List<Users> usuario = this.usersRepository.findByCorreo(correo,null);
		
		return usuario;
	}
	

}
