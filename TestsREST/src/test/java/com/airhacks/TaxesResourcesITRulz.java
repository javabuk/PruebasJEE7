package com.airhacks;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;

public class TaxesResourcesITRulz {
	@Rule
	public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/PruebasJEE7Septiembre/resources/taxes");

	@Rule
	public JAXRSClientProvider providerJSON = JAXRSClientProvider.buildWithURI("http://localhost:8080/PruebasJEE7Septiembre/resources/taxesJSON");
	
	@Test
	public void taxes() {
		Response response = provider.target().request().get();
		assertThat(response.getStatus(), is(200));
	}
	
	@Test
	public void taxesJSON(){
		Response response = providerJSON.target().request().get();
		assertThat(response.getStatus(), is(200));
		JsonObject tax = response.readEntity(JsonObject.class);
		assertNotNull(tax);
		System.out.println("tax = " + tax);
		
		
	}
	
	
}
