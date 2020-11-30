package com.lti.ecommerce.utility;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.lti.ecommerce.models.Product;

public class BuiltinFunctionalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//lambda
		//defn
		Function<Integer, Integer> generateOTP=(range)-> new Random().nextInt(range);
		//invoke		
		System.out.println(generateOTP.apply(10000));		
		
		//product as input and output should be expired or not
		Function<Product,Boolean> expiryStatus=(product)->LocalDate.now().isAfter(product.getDop());
		//invoke
		System.out.println(expiryStatus.apply(new Product(12,"Pickle",
				LocalDate.of(2020, 1, 24),200,"Aachi",4)));	
		
        BiFunction<Product,Product,String> productCompare=(p1,p2)->{
        	
        	String message=null;
        	if(p1.getCost()>p2.getCost())
        		message=p1.getBrand()+"is costlier than"+p2.getBrand();
        	else
        		message=p2.getBrand()+"is costlier than"+p1.getBrand();
        	return message;
        };
		
        System.out.println(productCompare.apply(new Product(12,"Pickle",
				LocalDate.of(2020, 1, 24),200,"Aachi",4),(new Product(12,"Pickle",
						LocalDate.of(2020, 1, 24),400,"PKV",4))));	
	}

}
