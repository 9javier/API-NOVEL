package com.example.prueba2.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.prueba2.Modelo.Usuario;

import com.example.prueba2.Repository.UsuarioRepository;
import com.mongodb.util.JSON;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private UsuarioRepository usuarioRepository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	/*Cosultar todos los usuarios de la BD
	@GetMapping("/all")
	public List<Usuario> getAll(){
		List<Usuario>  usuarios = this.usuarioRepository.findAll();
		
		return usuarios;
		
	}*/
	
	@GetMapping("/id/{id}")//Consultar un usuario de la BD por ID
	public Optional<Usuario> getById(@PathVariable("id")String id) {
		
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		return usuario;
	}
	
	@PostMapping//Insertar Usuario
	public String insertarUsuario(@RequestBody Usuario usuario) {
		this.usuarioRepository.insert(usuario);
		String objeto = "{'id':'"+usuario.getId()+"'}";//si se inseryo correctamente retornamos el id del registro.				
		return objeto;
	}
	
	@PutMapping//Actualizar usuario
	public void updatUsuario(@RequestBody Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")//Eliminar Usuario
	public void deleteUsuario(@PathVariable("id") String id) {
		this.usuarioRepository.deleteById(id);
	}	
	
	@GetMapping("/correo/{correo}")//Consultar el usuario de un cliente para autenticarse
	public List<Usuario> getUsuarioCliente(@PathVariable("correo") String correo){
		List<Usuario> usuario = this.usuarioRepository.findByCorreo(correo,null);
		
		return usuario;
	}
	

	
	/*
	@RequestMapping("/all")
	 public ResponseEntity<String> handle() throws URISyntaxException {
	   URI location = new URI("/all");
	   HttpHeaders responseHeaders = new HttpHeaders();
	   responseHeaders.setLocation(location);
	   responseHeaders.set("MyResponseHeader", "hola");
	  System.out.print( responseHeaders.getAllow());
	  
	   return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	 }
	
*/
	
	@RequestMapping(value = "/all")
	public List<Usuario> usuario(@RequestHeader(value="Apikey") String token) {
			
		if(token.equals("5d02b3e781562c489092c945")) {
			//System.out.println("consulta correcta");
		}else {//el token no es correcto
			
			return null;
		}
		List<Usuario>  usuarios = this.usuarioRepository.findAll();
		return usuarios;
	}
	
	
	//si usuario y key iguales entonces devolder true, si no es así mandar mensaje de su token no existe

	
	
	
}
