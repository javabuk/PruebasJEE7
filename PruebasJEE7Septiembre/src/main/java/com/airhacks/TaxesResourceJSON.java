package com.airhacks;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("taxesJSON")
public class TaxesResourceJSON {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject germany(){
		return Json.createObjectBuilder().add("tax", "19%").build();
	}
}
