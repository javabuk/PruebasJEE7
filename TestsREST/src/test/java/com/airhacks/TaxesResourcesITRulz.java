package com.airhacks;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;

public class TaxesResourcesITRulz {

	public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/PruebasJEE7Septiembre/resources/taxes");

	@Test
	public void taxes() {
		Response response = provider.target().request().get();
		assertThat(response.getStatus(), is(200));
	}
	
	
}
