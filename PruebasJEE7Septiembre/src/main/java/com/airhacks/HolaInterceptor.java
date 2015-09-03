package com.airhacks;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class HolaInterceptor {

	@AroundInvoke
	public Object modifyGreeting(InvocationContext ctx) throws Exception {
	    Object[] parameters = ctx.getParameters();
	    for (int i = 0; i < parameters.length; i++) {
			System.out.println("parametros: " + parameters[i]);
		}
//	    String param = (String) parameters[0];
//	    param = param.toLowerCase();
//	    parameters[0] = param;
//	    ctx.setParameters(parameters);
	    try {
	        return ctx.proceed();
	    } catch (Exception e) {
	        System.out.println("Error calling ctx.proceed in modifyGreeting()");
	        return null;
	    }
	}
	
}
