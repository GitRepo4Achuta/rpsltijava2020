package com.lti.ecommerce.facades;

public interface Payment {
	
	default boolean accept(double amount) {
		boolean status=false;
		if(amount>100)
			status=true;
		return status; 
	}

}
