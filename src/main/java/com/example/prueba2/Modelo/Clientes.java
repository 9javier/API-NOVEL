package com.example.prueba2.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Clientes implements Serializable{
	
	@Id
	@NotNull
	private String id;
	private String nombre;
	private String apellido;
	//private List<Clients> clients;
	private String estadoCuenta;
	private String correo;
	
	
	
	protected Clientes() {
		//this.clients = new ArrayList<>();
	}
	
	protected Clientes(String nombre, String apellido,String estadoCuenta, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.estadoCuenta= estadoCuenta;
		this.correo = correo;
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
