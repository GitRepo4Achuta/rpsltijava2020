package com.lti.ecommerce.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lti.ecommerce.models.Product;

public class ProductService {

	private List<Product> products;
	/*
	public List<Product> getProducts()
	{
		products=new ArrayList<Product>();
		Product product=null;
		
		for(int i=0;i<100;i++)
		{
			product=new Product();
			product.setProductId(new Random().nextInt(10000));
			product.setName("P"+new Random().nextInt(10000));					
			product.setDop(LocalDate.of(2000+new Random().nextInt(20), new Random().nextInt(10)+1, new Random().nextInt(27)+1));
			product.setCost(new Random().nextInt(10000));
			products.add(product);			
		}
	
		return products;
	}
	*/
	public static List<Product> getProductList()
	{
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1,"TV", LocalDate.of(2016, 9, 12),45000L,"Samsung",4));
		productList.add(new Product(21,"Laptop", LocalDate.of(2017, 3, 27),88000L,"DELL",5));
		productList.add(new Product(45,"Refrigerator", LocalDate.of(2018, 9, 12),145000L,"LG",3));
		productList.add(new Product(67,"Mobile", LocalDate.of(2019, 11, 12),75000L,"Apple",4));
		productList.add(new Product(3,"Laptop", LocalDate.of(2017, 9, 12),92000L,"Mac",3));
		productList.add(new Product(4,"Dishwasher", LocalDate.of(2020, 3, 12),25000L,"Samsung",3));
		
		
		
		return productList;
		
	}

}
