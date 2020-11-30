package com.lti.ecommerce.facades;

import java.util.Random;

@FunctionalInterface
public interface DataGenerator {
	
	String status();
	
	public static Integer getToken()
	{
		return new Random().nextInt(100000);
	}

}
