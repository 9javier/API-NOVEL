package com.example.prueba2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.prueba2.Modelo.HistorialPagos;
import com.example.prueba2.Repository.HistorialPagosRepository;


@Controller
@RequestMapping("/historial")//Ruta para acceder a la API
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class HistorialPagosController {


	/*@Autowired
	private MongoOperations mongoOperations;*/
	@Autowired
	private HistorialPagosRepository historialRepository;
	
	public HistorialPagosController(HistorialPagosRepository historialRepository) {
		this.historialRepository = historialRepository;	
	}

	
	@RequestMapping(value ="/all")
	@GetMapping("/all")//obtener todos los Historiales de pagos existentes
	public @ResponseBody Iterable<HistorialPagos> getHistoriales(@RequestHeader(value="Apikey")String token){
		Iterable<HistorialPagos> historial;
		if(token.equals("5d02b3e781562c489092c945")) {
			historial = this.historialRepository.findAll();

		}else {
			return null;
		}
		
		return historial;
	}
	
	@GetMapping("/codigo/{codigo}")//Consultar un historial de la BD por ID
	public @ResponseBody List<HistorialPagos> getById(@PathVariable("codigo")int codigo) {
		
		List<HistorialPagos> clientes = this.historialRepository.findBycodigo(codigo, null);
		return clientes;
	}
	
	//@RequestMapping(value ="/codigo/{codigo}")
	@PostMapping("/codigo/{codigo}")//insertar Historial de pago del cliente
	public @ResponseBody String InsertHistorial(@RequestBody HistorialPagos historialpagos, @RequestHeader(value="Apikey")String token) {
		
		String objeto;
		if(token.equals("5d02b3e781562c489092c945")) {
			//si la api key es correcta se hace la insercción del historial de pago
			historialRepository.save(historialpagos);

			 objeto ="{'id':'"+historialpagos.getCodigo()+"'}";//devuelve el codigo del cargo del historial
		}else {
			return null;//si la api key es incorrecta devolvemos un null
		}
		return objeto;
	}
	
	//@RequestMapping(value ="/delete/{codigo}")
	@Transactional
	@DeleteMapping("/codigo/{codigo}")//Eliminar cargos por codigo de cuenta.
	public @ResponseBody String deleteHistorial(@PathVariable("codigo") int id, @RequestHeader(value="Apikey")String token) {
		String objeto;
		if(token.equals("5d02b3e781562c489092c945")) {
			this.historialRepository.deleteByCodigo(id, null);
			objeto ="{'status':1}";
			
		}else {
			return null;
		}
		return objeto;
	}
	
	
	@GetMapping("/grupo/{grupo}")//Consultar estado de cuenta con el nombre del cliente
	public @ResponseBody List<HistorialPagos> cargos(@PathVariable("grupo")String grupo){
		List<HistorialPagos> historialpagos = historialRepository.findByGrupo(grupo,null);
		
		return historialpagos;
	}
	/*
	@GetMapping("/namelike/{nombre}")
	public List<HistorialPagos> getCargosNameLike(@PathVariable("nombre")String nombre){		
		String tagName = "";
		Query query = new Query();
		query.limit(10);		
		query.addCriteria(Criteria.where("nombre").regex(nombre));
		List<HistorialPagos> historialpagos= mongoOperations.find(query, HistorialPagos.class);
		
		return historialpagos;
		
	}*/
	@GetMapping("/name/{nombre}")
	public @ResponseBody List<HistorialPagos> getHistorialByNameLike(@PathVariable("nombre") String nombre){
		List<HistorialPagos> historial = this.historialRepository.findByNombreContaining(nombre);
		
		return historial;
		
	}
	
	
}
