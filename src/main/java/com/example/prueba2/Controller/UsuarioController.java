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

import com.example.prueba2.Modelo.Usuario;
import com.example.prueba2.Repository.UsuarioRepository;





@Controller
@RequestMapping(path="/usuario")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Usuario> getAllUsers(@RequestHeader(value="Apikey") String token) {
		// This returns a JSON or XML with the users
		if(token.equals("5d02b3e781562c489092c945")) {
			//System.out.println("consulta correcta");
		}else {//el token no es correcto
			
			return null;
		}
		Iterable<Usuario>  usuarios = usuarioRepository.findAll();
		return usuarios;
		
	}
	
	/*Obtner usuario ById*/	
	@GetMapping("/id/{id}")
	public @ResponseBody Optional<Usuario> getById(@PathVariable("id")int id){
	
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}
	
	
	@PostMapping
	public @ResponseBody String insertarUsuario(@RequestBody  Usuario usuario) {
		usuarioRepository.save(usuario);
		List<Usuario> us = getUsuarioCliente(usuario.getCorreo());
		String objeto = "{'id':'"+us.get(0).getId()+"'}";//si se inserto correctamente retornamos el id del registro.
		return objeto;
	}
	
	@PutMapping//Actualizar usuario
	public @ResponseBody String updatUsuario(@RequestBody Usuario usuario) {
		this.usuarioRepository.save(usuario);
		return "user updated";
	}
	@Transactional
	@DeleteMapping("/{id}")//Eliminar Usuario
	public  @ResponseBody String deleteUsuario(@PathVariable("id") int id) {
		this.usuarioRepository.deleteById(id);
		
		return "user deleted";
	}
	
	
	@GetMapping("/correo/{correo}")//Consultar el usuario de un cliente para autenticarse
	public @ResponseBody List<Usuario> getUsuarioCliente(@PathVariable("correo") String correo){
		List<Usuario> usuario = this.usuarioRepository.findByCorreo(correo,null);
		
		return usuario;
	}
	
	
	
}
