package com.example.prueba2.Modelo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="sesiones")
public class Sesiones {
	
	@Id
	@NotNull
	private String id;
	private String idusuario;
	private String fecha;
	
	public Sesiones() {
		
	}
	
	protected  Sesiones(String id_usuario,String fecha) {
		this.idusuario = id_usuario;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_usuario() {
		return idusuario;
	}

	public void setId_usuario(String id_usuario) {
		this.idusuario = id_usuario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
