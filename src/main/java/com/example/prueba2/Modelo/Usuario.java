package com.example.prueba2.Modelo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usuarios")
public class Usuario {

	@Id
	@NotNull
	private String id;
	private String correo;
	private String password;
	private String nombre;
	private String telefono;
	
	protected Usuario() {
		
	}
	
	protected Usuario(String correo,String password,String nombre,String telefono) {
		this.correo= correo;
		this.password = password;
		this.nombre= nombre;
		this.telefono = telefono;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
}
