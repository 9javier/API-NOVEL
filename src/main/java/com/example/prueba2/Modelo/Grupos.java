package com.example.prueba2.Modelo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="grupos")
public class Grupos {
	@Id
	@NotNull
	private String id;
	private String desc;
	
	
	public Grupos() {
		
	}
	
	protected Grupos(String desc) {
		this.desc = desc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
