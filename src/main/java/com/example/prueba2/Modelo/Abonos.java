package com.example.prueba2.Modelo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="abonos")
public class Abonos {
	@Id
	@NotNull
	private String id;
	private int codigo;
	private double abono;
	
	public Abonos() {
		
	}
	
	protected Abonos(int codigo, double abono) {
		this.codigo = codigo;
		this.abono = abono;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getAbono() {
		return abono;
	}

	public void setAbono(double abono) {
		this.abono = abono;
	}
	
	
	
	
}
