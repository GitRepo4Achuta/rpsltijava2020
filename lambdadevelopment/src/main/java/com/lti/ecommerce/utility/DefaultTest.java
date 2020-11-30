package com.lti.ecommerce.utility;

import com.lti.ecommerce.models.CreditCard;
import com.lti.ecommerce.models.GooglePay;

public class DefaultTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CreditCard creditCard=new CreditCard(10000,false);
		System.out.println(creditCard.accept(3000));		
		System.out.println(new GooglePay().accept(50));
		
	}

}
