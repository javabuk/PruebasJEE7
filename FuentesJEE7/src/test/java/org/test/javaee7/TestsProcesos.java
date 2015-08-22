package org.test.javaee7;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pruebas.javaee7.Proceso;

public class TestsProcesos {

	private Proceso proceso;
	
	@Before
	public void setUp() throws Exception {
		Map properties = new HashMap<>();
		//D:\Programas\wls12130\wlserver\server\lib
		properties.put(EJBContainer.MODULES, "D:\\Programas\\wls12130\\wlserver\\server\\lib\\wlclient.jar");
		
		properties.put(EJBContainer.PROVIDER, "weblogic.ejb.embeddable.EJBContainerProvider");
		
		EJBContainer container = EJBContainer.createEJBContainer(properties);
		
		Object objeto = container.getContext().lookup("java:global/Proceso");
		
		assertTrue(objeto instanceof Proceso);
		proceso = (Proceso)objeto;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String resultado = proceso.metodoPrueba();
		assertTrue("hola".equalsIgnoreCase(resultado));
	}

}
