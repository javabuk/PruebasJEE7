package com.airhacks;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.SessionCookieConfig;

public class HolaInterceptor {

	@Resource
	private SessionContext sessionCtx;
	
	@AroundInvoke
	public Object modifyGreeting(InvocationContext ctx) throws Exception {
	    //Usuario
		System.out.print(sessionCtx.getCallerPrincipal().getName() + "-");
		//Nombre de la clase
		System.out.print(ctx.getTarget().getClass().getName() + " ");
		//Nombre del método
		System.out.print(ctx.getMethod().getName());
		
		Object[] parameters = ctx.getParameters();
	    
	    for (int i = 0; i < parameters.length; i++) {
			System.out.print(" parametros: " + parameters[i]);
		}
//	    String param = (String) parameters[0];
//	    param = param.toLowerCase();
//	    parameters[0] = param;
//	    ctx.setParameters(parameters);
	    try {
	        Object objetoDevuelto = ctx.proceed();
	    	System.out.println(" Valor devuelto:  " + objetoDevuelto.toString());
	    	return objetoDevuelto;
	    } catch (Exception e) {
	        System.out.println("Error calling ctx.proceed in modifyGreeting()");
	        return null;
	    }
	}
	
}
