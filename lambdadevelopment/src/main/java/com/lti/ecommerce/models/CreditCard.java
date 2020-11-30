package com.lti.ecommerce.models;

import com.lti.ecommerce.facades.Payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard implements Payment {

	private long balance;
	private boolean status;
	
	
	@Override
	public boolean accept(double amount) {
		// TODO Auto-generated method stub
		if(amount<balance)
			status=true;
		return status;
	}

}
