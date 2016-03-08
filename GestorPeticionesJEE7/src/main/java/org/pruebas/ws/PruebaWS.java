package org.pruebas.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.pruebas.enumerados.*;
import org.pruebas.statemachine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

@WebService( serviceName="Prueba")
public class PruebaWS {

	private final String mensaje = "HOLA";
	
	@Autowired
    private StateMachine<States, Events> stateMachine;

	public PruebaWS() {

	}
	
	@WebMethod
	public String diHola(String nombre){
		stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
		return mensaje + " " + nombre;
	}
	
}
