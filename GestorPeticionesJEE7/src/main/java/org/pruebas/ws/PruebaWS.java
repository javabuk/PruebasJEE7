package org.pruebas.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService( serviceName="Prueba")
public class PruebaWS {

	private final String mensaje = "HOLA";

	public PruebaWS() {

	}
	
	@WebMethod
	public String diHola(String nombre){
		return mensaje + " " + nombre;
	}
	
}
