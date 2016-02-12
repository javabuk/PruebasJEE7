package com.airhacks;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class TaxesResouceIT {

	private Client client;
	private WebTarget webTarget;

	@Before
	public void initClient() throws Exception {
		this.client = ClientBuilder.newClient();
		webTarget = this.client.target("http://localhost:8080/PruebasJEE7Septiembre/resources/taxes");
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void taxes() {
		Response response = this.webTarget.request().get();
		assertThat(response.getStatus(), is(200));
	}

}
