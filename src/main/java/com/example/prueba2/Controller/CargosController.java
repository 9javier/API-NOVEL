package com.example.prueba2.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.prueba2.Modelo.Cargos;
import com.example.prueba2.Modelo.Codes;
import com.example.prueba2.Repository.CargosRepository;
import com.example.prueba2.Repository.ClientesRepository;


@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CargosController {
private CargosRepository cargosRepository;

@Autowired
private MongoOperations mongoOperations;

	public CargosController(CargosRepository cargosRepository) {
		this.cargosRepository = cargosRepository;
	}
	
	@GetMapping("/all")
	public List<Cargos> getAll(){
		List<Cargos> cargos = cargosRepository.findAll();
		return cargos;
	}
	
	@RequestMapping(value = "/nombre/{nombre}")
	@GetMapping("/nombre/{nombre}")//Consultar estado de cuenta con el nombre del cliente
	public List<Cargos> cargos(@PathVariable("nombre")String idcliente,@RequestHeader(value="Apikey") String token){
		List<Cargos> cargos = cargosRepository.findByNombre(idcliente,null);
		if(token.equals("5d02b3e781562c489092c945")) {
			//System.out.println("consulta correcta");
		}else {//el token no es correcto
			
			return null;
		}
		
		
		return cargos;
	}

	
	@GetMapping("/grupo/{grupo}")//Consultar estado de cuenta con el nombre del cliente
	public List<Cargos> cargos(@PathVariable("grupo")String grupo){
		List<Cargos> cargos = cargosRepository.findByGrupo(grupo,null);
		
		return cargos;
	}
	
	@GetMapping("/c/{nombre}")
	public List<Cargos> getCargosNameLike(@PathVariable("nombre")String nombre){		
		String tagName = "";
		Query query = new Query();
		query.limit(10);		
		query.addCriteria(Criteria.where("nombre").regex(nombre));
		List<Cargos> cargos= mongoOperations.find(query, Cargos.class);
		
		return cargos;
		
	}
	
	@RequestMapping(value ="/codigo/{codigo}")
	@GetMapping("/codigo/{codigo}")
	public List<Cargos> getCargosCodigo(@PathVariable("codigo")int codigo,@RequestHeader(value="Apikey")String token){
		List<Cargos> cargos = cargosRepository.findByCodigo(codigo, null);
		if(token.equals("5d02b3e781562c489092c945")) {
			//api key correcto
		}else {
			return null;
		}
		return cargos;
	}
	
	@PostMapping
	public String insertCargo(@RequestBody Cargos cargos) {
		this.cargosRepository.insert(cargos);
		return "Accept";
	}
	
	@PutMapping
	public void updateCargo(@RequestBody Cargos cargos) {
		this.cargosRepository.save(cargos);
	}
	@RequestMapping(value ="/d/{codigo}")
	@DeleteMapping("/d/{codigo}")//Eliminar cargos por codigo de cuenta.
	public String deleteCargo(@PathVariable("codigo") int id, @RequestHeader(value="Apikey")String token) {
		String objeto;
		if(token.equals("5d02b3e781562c489092c945")) {
			this.cargosRepository.deleteByCodigo(id, null);
			objeto ="{'status':1}";
			
		}else {
			return null;
		}
		return objeto;
	}
	
}
