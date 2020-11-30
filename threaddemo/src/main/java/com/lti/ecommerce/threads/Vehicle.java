package com.lti.ecommerce.threads;

public class Vehicle extends Automobile{
	
	public void getMessage(String name)
	{
		for(char letter : name.toCharArray() )
		{
			System.out.print(letter);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n");
		
	}

}
