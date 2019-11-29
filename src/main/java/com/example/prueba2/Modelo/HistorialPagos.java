package com.example.prueba2.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="histpagos")
public class HistorialPagos {
	
	@Id
	@NotNull
	private int id;
	private int codigo;
	private String Productos;
	private String Fecha;
	private String nombre;
	private String grupo;
	
	public HistorialPagos() {
		
	}
	
	public HistorialPagos(int id,int CodigoCuenta,String Productos, String Fecha, String nombre,String grupo) {
		this.id=id;
		this.codigo = CodigoCuenta;
		this.Productos = Productos;
		this.Fecha = Fecha;
		this.nombre= nombre;
		this.grupo = grupo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProductos() {
		return Productos;
	}

	public void setProductos(String productos) {
		Productos = productos;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	
	

}
