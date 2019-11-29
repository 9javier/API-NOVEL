package com.example.prueba2.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name ="cargos")
public class Cargos {

	@Id
	@NotNull
	private int id;
	private String nombre;
	private String productos;
	private double total;
	private int codigo;
	private String grupo;
	private String email;
	
	public Cargos() {
		
	}
	
	protected Cargos(String nombre, String productos,double total,int codigo,String grupo,String email) {
		this.nombre = nombre;
		this.productos = productos;
		this.total = total;
		this.codigo = codigo;
		this.grupo = grupo;
		this.email = email;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
