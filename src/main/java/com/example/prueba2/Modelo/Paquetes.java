package com.example.prueba2.Modelo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="paquetes")
public class Paquetes {
	@Id
	@NotNull
	private String id;
	private String desc;
	private double precio;
	
	public Paquetes() {
		
	}

	protected Paquetes(String desc, double precio) {
		this.desc = desc;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	
	
}
