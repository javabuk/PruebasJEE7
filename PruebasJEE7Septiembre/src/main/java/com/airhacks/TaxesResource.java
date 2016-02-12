package com.airhacks;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("taxes")
public class TaxesResource {

	@GET
	public String germany(){
		return "19%";
	}
}
