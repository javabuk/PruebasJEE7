package com.airhacks;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("taxesJSON")
public class TaxesResourceJSON {

	@Inject
	TaxCalculator tc;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject germany(){
		int tax = tc.computeTax(20);
		
		JsonObject objetoJSON = Json.createObjectBuilder().add("tax", "19%").add("taxEJB", tax).build();
		
		return objetoJSON;
	}
}
