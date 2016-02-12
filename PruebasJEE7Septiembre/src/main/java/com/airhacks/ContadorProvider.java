package com.airhacks;

public class ContadorProvider {
	
	private static int contador;
	
	public int getContador(){
		return contador++;
	}

}
