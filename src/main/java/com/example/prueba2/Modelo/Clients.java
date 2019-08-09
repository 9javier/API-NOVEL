package com.example.prueba2.Modelo;

public class Clients {

	private String nombre;
	private String apellido;
	protected Clients() {
		
	}
	
	public Clients(String userName, String apellido) {
		this.nombre = userName;
		this.apellido = apellido;
		
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
	
}
