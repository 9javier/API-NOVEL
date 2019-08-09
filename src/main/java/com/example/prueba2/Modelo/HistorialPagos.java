package com.example.prueba2.Modelo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="historial")
public class HistorialPagos {
	
	@Id
	@NotNull
	private String id;
	private int codigo;
	private String Productos;
	private String Fecha;
	
	protected HistorialPagos() {
		
	}
	
	public HistorialPagos(int CodigoCuenta,String Productos, String Fecha) {
		this.codigo = CodigoCuenta;
		this.Productos = Productos;
		this.Fecha = Fecha;
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
	
	
	

}
