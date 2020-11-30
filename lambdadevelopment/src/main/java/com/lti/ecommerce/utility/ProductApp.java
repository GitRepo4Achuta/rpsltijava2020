package com.lti.ecommerce.utility;

import com.lti.ecommerce.models.Product;
import com.lti.ecommerce.services.ProductService;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//traditional code
		ProductService productService=new ProductService();
		/*
		 * for(Product product: productService.getProducts()) {
		 * System.out.println(product.getProductId()+","+product.getName()
		 * +","+product.getDop()+","+product.getCost()); }
		 */
		//lambda approach
		productService.getProducts().stream().forEach(System.out::println);
		
		//filter chain of operations
		productService.getProducts().stream()
		.filter(p->p.getCost()>5000)
		.forEach(System.out::println);
		
	}

}
