package com.airhacks;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.SessionCookieConfig;

public class HolaInterceptor {

	private Logger logger = Logger.getLogger("HolaInterceptor");
	
	@Resource
	private SessionContext sessionCtx;
	
	@Inject
	ContadorProvider contador;
	
	@AroundInvoke
	public Object modifyGreeting(InvocationContext ctx) throws Exception {
		int idTraza = contador.getContador();
		logger.info("[ID] " + idTraza + " - "
				+ "Usuario: " + sessionCtx.getCallerPrincipal().getName()
				+", Clase: " + ctx.getTarget().getClass().getName()
				+", Metodo: " + ctx.getMethod().getName()
				+ ", Parametros: "+Arrays.toString(ctx.getParameters()));		
		
	    try {
	        Object objetoDevuelto = ctx.proceed();
	        logger.info("[ID] " + idTraza + " - "
					+ " Valor devuelto:  " + objetoDevuelto.toString());
	    	return objetoDevuelto;
	    } catch (Exception e) {
	    	logger.severe("Error calling ctx.proceed in modifyGreeting()");
	        return null;
	    }
	}
	
}
