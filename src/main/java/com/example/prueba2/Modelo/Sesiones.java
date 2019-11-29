package com.example.prueba2.Modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="sesiones")
public class Sesiones {
	
	@javax.persistence.Id
	@NotNull
	private int id;
	private int idusuario;
	private String fecha;
	
	public Sesiones() {
		
	}
	
	protected Sesiones(int id,int idusuario,String fecha) {
		this.id=id;
		this.idusuario =idusuario;
		this.fecha= fecha;
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
