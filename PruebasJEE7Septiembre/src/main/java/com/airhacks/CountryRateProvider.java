package com.airhacks;

public class CountryRateProvider {

	public int country(String code){
		if("germany".equalsIgnoreCase(code)){
			return 19;
		}else {
			return 42;
		}
	}
	
}
