package com.example.prueba2.Controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;

@RestController
@RequestMapping("/mercado")
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MercadopagoController {

	public void Mercadopagos() throws MPException, MPConfException {
		
	}
	
	@GetMapping("/id")//Consultar un usuario de la BD por ID
	public String getById(@RequestHeader(value="nombre") String nombre,
			@RequestHeader(value="descripcion") String desc,
			@RequestHeader(value="monto")float monto,
			@RequestHeader(value="email")String email) throws MPException, MPConfException {
		MercadoPago.SDK.setAccessToken("APP_USR-6679782106343605-071621-1f2d05cbe87fcdfcd1e9ba74a46cc3c5-452301900");
		//MercadoPago.SDK.setAccessToken("TEST-6679782106343605-071621-b73b42b883abc8cd996cdeff6f35fef7-452301900");
		MercadoPago.SDK.setClientSecret(System.getenv("aTDrTfXdG7JmGAtC0J1vVI81wYBGMuLd"));
       MercadoPago.SDK.setClientId(System.getenv("6679782106343605"));
       //MercadoPago.SDK.setAppId(System.getenv("6679782106343605"));
      
         
      Payer payer = new Payer();
       payer.setName(nombre)
            .setSurname("")
            .setEmail(email)
            .setDateCreated(new Date().toString())
            .setPhone(new Phone().setAreaCode("").setNumber("6182931794"))
            .setIdentification(new Identification()
               .setType("DNI")
               .setNumber("970314"))
            .setAddress(new Address()
               .setStreetName("1 de Mayo")
 
               .setZipCode("34168"));
       
       
       Preference preference = new Preference();

       Item item = new Item();
       item.setId("1234")
           .setTitle("Pago de servicio Novel")
           .setDescription(desc)
           .setQuantity(1)
           .setCurrencyId("MXN")
           .setUnitPrice((float) monto);
      


       preference.setPayer(payer);
       preference.appendItem(item);
       preference.setBinaryMode(true);
       //preference.setPaymentMethods(new PaymentMethods().setExcludedPaymentTypes("Efectivo"));
       //preference.setPaymentMethods(new PaymentMethods().setExcludedPaymentMethods("Efectivo"));
       preference.save();
      
     //System.out.println("ll:"+ preference.getSandboxInitPoint()); 
      //System.out.println(preference.getId());
		return preference.getId();
	}
	
}
