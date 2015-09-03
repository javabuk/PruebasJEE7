package com.airhacks;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TaxCalculator {

	@Inject
	CountryRateProvider crp;
	
	public int computeTax(int price){
		int rate = crp.country("germany");
		return price * rate;
	}
}
