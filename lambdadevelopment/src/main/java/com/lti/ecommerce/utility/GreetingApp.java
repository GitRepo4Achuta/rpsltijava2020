package com.lti.ecommerce.utility;

import com.lti.ecommerce.facades.Greeting;

public class GreetingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//lambda expression
		Greeting greeting=(name)->{
			return "Hi"+name+" !!Welcome to LTI Training";
		};
		
		System.out.println(greeting.message("Roshan"));
		
	}

}
