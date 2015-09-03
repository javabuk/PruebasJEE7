package com.airhacks;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(HolaInterceptor.class)
public class TaxCalculator {

	@Inject
	CountryRateProvider crp;
	
	public int computeTax(int price){
		int rate = crp.country("germany");
		return price * rate;
	}
}
