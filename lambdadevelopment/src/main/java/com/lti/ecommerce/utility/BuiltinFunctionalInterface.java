package com.lti.ecommerce.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.lti.ecommerce.facades.DataGenerator;
import com.lti.ecommerce.facades.TriFunction;
import com.lti.ecommerce.models.Product;
import com.lti.ecommerce.services.ProductService;

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
        
                
        TriFunction<Integer,Integer,Integer, Double> meanCost=(c1,c2,c3)->(c1+c2+c3)/3.0;
        System.out.println(meanCost.apply(new Random().nextInt(10000),new Random().nextInt(10000)
        		, new Random().nextInt(10000)));
        
        
        Consumer<List<Product>> showProducts=(products)->{
        	products.stream().forEach(System.out::println);
        };
        
        showProducts.accept(new ProductService().getProductList());
        
        Supplier<Integer> tokenGenerator=DataGenerator::getToken;
        System.out.println(tokenGenerator.get());
        
	}

}
