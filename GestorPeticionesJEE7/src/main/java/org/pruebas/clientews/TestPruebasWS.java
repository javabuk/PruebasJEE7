package org.pruebas.clientews;

import javax.xml.ws.WebServiceRef;
import org.pruebas.ws.*;

public class TestPruebasWS {

	@WebServiceRef(wsdlLocation="http://localhost:8080/GestorPeticionesJEE7/Prueba?wsdl")
	static PruebaWS service;
	
	public static void main(String[] args) {
		try {
			TestPruebasWS client = new TestPruebasWS();
			client.doTest(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		  public void doTest(String[] args) {
		    try {
		      System.out.println("Retrieving the port from the following service: " + service);
		      System.out.println("Invoking the sayHello operation on the port.");
		      
		      String response = service.diHola("Jorge");
		      System.out.println(response);
		    } catch(Exception e) {
		      e.printStackTrace();
		    }
		  }
	
}
