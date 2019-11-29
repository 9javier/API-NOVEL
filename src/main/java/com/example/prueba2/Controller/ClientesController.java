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

import com.example.prueba2.Modelo.Clientes;
import com.example.prueba2.Repository.ClientesRepository;

@Controller
@RequestMapping(path="/clientes")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientesController {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clientes> getAll(){
		Iterable<Clientes> clientes = clientesRepository.findAll();
		
		return clientes;
	}
	
	@GetMapping("/id/{id}")//Consultar un clientes de la BD por ID
	public @ResponseBody Optional<Clientes> getById(@PathVariable("id")int id) {
		
		Optional<Clientes> clientes = this.clientesRepository.findById(id);
		return clientes;
	}
	
	@GetMapping("/nombre/{nombre}")//Consultar clientes por su nombre
	public @ResponseBody List<Clientes> getByName(@PathVariable("nombre")String nombre){
		List<Clientes> clientes = this.clientesRepository.findByNombre(nombre, null);
		
		return clientes;
	}
	
	@GetMapping("/apellido/{apellido}")//Consultar cliente por apellido
	public @ResponseBody List<Clientes> getByApellido(@PathVariable("apellido") String apellido){
		List<Clientes> clientes = this.clientesRepository.findByApellido(apellido, null);
		
		return clientes;
	}
	

	@PostMapping//Insertar cliente
	public @ResponseBody String insert(@RequestBody Clientes cliente) {
			clientesRepository.save(cliente);
			return "save";
	}
	
	@PutMapping//Actualizar cliente
	public @ResponseBody String update(@RequestBody Clientes cliente) {
		clientesRepository.save(cliente);
		
		return "client updated";
	}
	@Transactional
	@DeleteMapping("/{id}")//Eliminar cliente por su ID
	public void delete(@PathVariable("id") int id) {
		this.clientesRepository.deleteById(id);
	}
}
