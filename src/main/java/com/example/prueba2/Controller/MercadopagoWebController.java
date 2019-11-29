package com.example.prueba2.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

@RestController
@RequestMapping("/mercadoweb")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MercadopagoWebController {

public void Mercadopagos() throws MPException, MPConfException {
		
	}
	
@PostMapping("/id/{id}")
public String getById(@PathVariable(value="id")int id,
		@RequestParam(value="token") String token,
		@RequestParam(value="payment_method_id") String payment_method_id,
		@RequestParam(value="installments") int installments,
		@RequestParam(value="issuer_id") int issuer_id) throws MPException {
	
	MercadoPago.SDK.setAccessToken("TEST-6679782106343605-071621-b73b42b883abc8cd996cdeff6f35fef7-452301900");
	//...
	Payment payment = new Payment();
	payment.setTransactionAmount((float) 177)
	       .setToken(token)
	       .setDescription("Intelligent Silk Car")
	       .setInstallments(installments)
	       .setPaymentMethodId(payment_method_id)
	       .setPayer(new Payer()
	         .setEmail("roma@hotmail.com"));
	// Guarda y postea el pago
	payment.save();
	//...
	// Imprime el estado del pago
	System.out.println(payment.getStatus()+"\n"+
	payment.getId());
	
	if(payment.getStatus().toString().equalsIgnoreCase("approved")) {
		String mensaje="<style type='text/css'> .btn {\r\n" + 
				"  background-color: DodgerBlue;\r\n" + 
				"  border: none;\r\n" + 
				"  color: white;\r\n" + 
				"  padding: 12px 30px;\r\n" + 
				"  cursor: pointer;\r\n" + 
				"  font-size: 20px;\r\n" + 
				"  position: absolute;\r\n" + 
				"  top:58%;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* Darker background on mouse-over */\r\n" + 
				".btn:hover {\r\n" + 
				"  background-color: RoyalBlue;\r\n" + 
				"}</style>"
				+ "<head>\r\n" + 
				"	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\'>\r\n" + 
				"</head>"
				+ "<h1 style='text-align:center;'>Pagó exitoso</h1>"
				+ "<br>"+
				"<button class='btn' onclick='download();'><i class='fa fa-download'></i> Descargar</button>"
				+ ""+
				"<script type='text/javascript'> function download(){ location.href='http://fotopanoramicasnovel.com/photos/download.php?id="+id+"';}</script>";
		return mensaje;
	}
	
	return "<h1 style='text-align:center'>No se pudo procesar tu pagó, intentalo mas tarde</h1>";
	
}



	
}
