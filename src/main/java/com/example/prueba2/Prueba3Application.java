package com.example.prueba2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;

@SpringBootApplication
public class Prueba3Application {

	public static void main(String[] args) throws MPException, MPConfException {
										

		SpringApplication.run(Prueba3Application.class, args);
	     
	}


}
