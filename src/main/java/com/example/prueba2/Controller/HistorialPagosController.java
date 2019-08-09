package com.example.prueba2.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.prueba2.Modelo.HistorialPagos;
import com.example.prueba2.Repository.HistorialPagosRepository;

@RestController
@RequestMapping("/historial")//Ruta para acceder a la API
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class HistorialPagosController {

	private HistorialPagosRepository historialRepository;
	public HistorialPagosController(HistorialPagosRepository historialRepository) {
		this.historialRepository = historialRepository;
		
	}
	
	@RequestMapping(value ="/all")
	@GetMapping("/all")//obtener todos los Historiales de pagos existentes
	public List<HistorialPagos> getHistoriales(@RequestHeader(value="Apikey")String token){
		List<HistorialPagos> historial;
		if(token.equals("5d02b3e781562c489092c945")) {
			historial = this.historialRepository.findAll();

		}else {
			return null;
		}
		
		return historial;
	}
	
	@GetMapping("/codigo/{codigo}")//Consultar un historial de la BD por ID
	public List<HistorialPagos> getById(@PathVariable("codigo")int codigo) {
		
		List<HistorialPagos> clientes = this.historialRepository.findBycodigo(codigo, null);
		return clientes;
	}
	
	@RequestMapping(value ="/codigo/{codigo}")
	@PostMapping()//insertar Historial de pago del cliente
	public String InsertHistorial(@RequestBody HistorialPagos historialpagos, @RequestHeader(value="Apikey")String token) {
		String objeto;
		if(token.equals("5d02b3e781562c489092c945")) {
			//si la api key es correcta se hace la insercción del historial de pago
			this.historialRepository.insert(historialpagos);
			 objeto ="{'id':'"+historialpagos.getId()+"'}";
		}else {
			return null;//si la api key es incorrecta devolvemos un null
		}
		
		return objeto;
		
	}
	
}
