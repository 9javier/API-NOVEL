package com.example.prueba2.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name ="codes")
public class Codes {
	@Id
	@NotNull
	private int id;
	private int codigo;
	
	public Codes() {
		
	}
	public Codes(int codigo) {
		this.codigo =codigo;
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
