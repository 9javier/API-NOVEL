package com.example.prueba2.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba2.Modelo.Clientes;
import com.example.prueba2.Modelo.Usuario;
import com.example.prueba2.Repository.ClientesRepository;
import com.example.prueba2.Repository.UsuarioRepository;

@RestController
@RequestMapping("/clientes")//Ruta para acceder a la API
public class ClientesController {
	private ClientesRepository clienteRepository;

	public ClientesController(ClientesRepository usuarioRepository) {
		this.clienteRepository = usuarioRepository;
	}
	
	@GetMapping("/all")//consultar todos los clientes de la BD
	public List<Clientes> getAll(){
		List<Clientes> clientes = this.clienteRepository.findAll();
		
		return clientes;
	}
	
	@GetMapping("/id/{id}")//Consultar un clientes de la BD por ID
	public Optional<Clientes> getById(@PathVariable("id")String id) {
		
		Optional<Clientes> clientes = this.clienteRepository.findById(id);
		return clientes;
	}
	
	@GetMapping("/nombre/{nombre}")//Consultar clientes por su nombre
	public List<Clientes> getByName(@PathVariable("nombre")String nombre){
		List<Clientes> clientes = this.clienteRepository.findByNombre(nombre, null);
		
		return clientes;
	}
	
	@GetMapping("/apellido/{apellido}")//Consultar cliente por apellido
	public List<Clientes> getByApellido(@PathVariable("apellido") String apellido){
		List<Clientes> clientes = this.clienteRepository.findByApellido(apellido, null);
		
		return clientes;
	}
	
	
	@PostMapping//Insertar cliente
	public void insert(@RequestBody Clientes cliente) {
			this.clienteRepository.insert(cliente);
	}
	
	@PutMapping//Actualizar cliente
	public void update(@RequestBody Clientes cliente) {
		this.clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")//Eliminar cliente por su ID
	public void delete(@PathVariable("id") String id) {
		this.clienteRepository.deleteById(id);
	}
	
	
	
}
