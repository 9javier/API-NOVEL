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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.prueba2.Modelo.Cargos;
import com.example.prueba2.Repository.CargosRepository;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/cargos")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CargosController {
@Autowired
private CargosRepository cargosRepository;

/*@Autowired
private MongoOperations mongoOperations;*/

	public CargosController(CargosRepository cargosRepository) {
		this.cargosRepository = cargosRepository;
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Cargos> getAll(){
		Iterable<Cargos> cargos = cargosRepository.findAll();
		return cargos;
	}
	
	@RequestMapping(value = "/nombre/{nombre}")
	@GetMapping("/nombre/{nombre}")//Consultar estado de cuenta con el nombre del cliente
	public @ResponseBody List<Cargos> cargos(@PathVariable("nombre")String idcliente,@RequestHeader(value="Apikey") String token){
		List<Cargos> cargos = cargosRepository.findByNombre(idcliente,null);
		if(token.equals("5d02b3e781562c489092c945")) {
			//System.out.println("consulta correcta");
		}else {//el token no es correcto
			
			return null;
		}
		
		
		return cargos;
	}

	
	@GetMapping("/grupo/{grupo}")//Consultar estado de cuenta con el nombre del cliente
	public @ResponseBody List<Cargos> cargos(@PathVariable("grupo")String grupo){
		List<Cargos> cargos = cargosRepository.findByGrupo(grupo,null);
		
		return cargos;
	}
	/*
	@GetMapping("/c/{nombre}")
	public List<Cargos> getCargosNameLike(@PathVariable("nombre")String nombre){		
		String tagName = "";
		Query query = new Query();
		query.limit(10);		
		query.addCriteria(Criteria.where("nombre").regex(nombre));
		List<Cargos> cargos= mongoOperations.find(query, Cargos.class);
		
		return cargos;
		
	}*/
	@GetMapping("/name/{nombre}")
	public @ResponseBody List<Cargos> getCargosNombreLike(@PathVariable("nombre")String nombre){
	List<Cargos> cargos =	this.cargosRepository.findByNombreContaining(nombre,null);
		
		return cargos;
	}
	
	@RequestMapping(value ="/codigo/{codigo}")
	@GetMapping("/codigo/{codigo}")
	public @ResponseBody List<Cargos> getCargosCodigo(@PathVariable("codigo")int codigo,@RequestHeader(value="Apikey")String token){
		List<Cargos> cargos = cargosRepository.findByCodigo(codigo, null);
		if(token.equals("5d02b3e781562c489092c945")) {
			//api key correcto
		}else {
			return null;
		}
		return cargos;
	}
	
	@PostMapping
	public @ResponseBody String insertCargo(@RequestBody Cargos cargos) {
		this.cargosRepository.save(cargos);
		return "Accept";
	}
	
	@PutMapping
	public @ResponseBody String updateCargo(@RequestBody Cargos cargos) {
		this.cargosRepository.save(cargos);
		
		return "Cargos updated";
	}
	//@RequestMapping(value ="/d/{codigo}")
	@Transactional
	@DeleteMapping("/d/{codigo}")//Eliminar cargos por codigo de cuenta.
	public @ResponseBody String deleteCargo(@PathVariable("codigo") int id, @RequestHeader(value="Apikey")String token) {
		String objeto;
		if(token.equals("5d02b3e781562c489092c945")) {
			this.cargosRepository.deleteByCodigo(id, null);
			objeto ="{'status':1}";
			
		}else {
			return null;
		}
		return objeto;
	}
	
	@RequestMapping(value ="/abono/{codigo}")
	@GetMapping("/abono/{codigo}")
	public @ResponseBody String AbonoByCodigo(@PathVariable("codigo")int codigo,
		@RequestHeader(value="Apikey")String token,@RequestHeader(value="abono")double abono){
		List<Cargos> cargos = cargosRepository.findByCodigo(codigo, null);
		if(token.equals("5d02b3e781562c489092c945")) {
			//api key correcto
			double total = cargos.get(0).getTotal();
			double totalFinal = total-abono;
			cargos.get(0).setTotal(totalFinal);
			
			
		Cargos c= new Cargos();
		c.setCodigo(cargos.get(0).getCodigo());
		c.setEmail(cargos.get(0).getEmail());
		c.setGrupo(cargos.get(0).getGrupo());
		c.setId(cargos.get(0).getId());
		c.setNombre(cargos.get(0).getNombre());
		c.setProductos(cargos.get(0).getProductos());
		c.setTotal(cargos.get(0).getTotal());
		updateCargo(c);
		String res  ="{'total':"+cargos.get(0).getTotal()+"}";
		return res;
		}else {
			return null;
		}
		
	}
	
	
	
	
}
