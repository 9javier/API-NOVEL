package com.example.prueba2.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name ="clientes")
public class Clientes {

	@Id
	@NotNull
	private int id;
	private String nombre;
	private String apellido;
	private String escuenta;
	private String correo;
	
	
	
	public Clientes() {
		//this.clients = new ArrayList<>();
	}
	
	public Clientes(String nombre, String apellido,String estadoCuenta, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.escuenta= estadoCuenta;
		this.correo = correo;
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEscuenta() {
		return escuenta;
	}

	public void setEscuenta(String escuenta) {
		this.escuenta = escuenta;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
