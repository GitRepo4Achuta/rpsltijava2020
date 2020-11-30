package com.lti.ecommerce.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lti.ecommerce.models.Product;

public class ProductService {

	private List<Product> products;
	
	public List<Product> getProducts()
	{
		products=new ArrayList<Product>();
		Product product=null;
		
		for(int i=0;i<100;i++)
		{
			product=new Product();
			product.setProductId(new Random().nextInt(10000));
			product.setName("P"+new Random().nextInt(10000));					
			product.setDop(LocalDate.of(2000+new Random().nextInt(20), new Random().nextInt(10)+1, new Random().nextInt(29)+1));
			product.setCost(new Random().nextInt(10000));
			products.add(product);			
		}
		
		return products;
	}
	
	
}
