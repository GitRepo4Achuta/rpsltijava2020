package com.lti.ecommerce.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lti.ecommerce.models.Product;
import com.lti.ecommerce.services.ProductService;

public class ProductApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//traditional code
		ProductService productService=new ProductService();
		/*
		//Iterable
		
		Iterator iterator=productService.getProducts().iterator();
		
		Product product=null;
		while(iterator.hasNext())
		{
			product=(Product) iterator.next();
			 System.out.println(product.getProductId()+","+product.getName()
			 +","+product.getDop()+","+product.getCost());
			
		}
		*/
		
		
		
		
		
		/*
		
		 for(Product product: productService.getProducts()) {
		 System.out.println(product.getProductId()+","+product.getName()
		 +","+product.getDop()+","+product.getCost()); }
		 
		 */
		 
		//lambda approach
		//productService.getProducts().stream().forEach(System.out::println);
		
		//filter chain of operations
		//productService.getProducts().stream()
		//.filter(p->p.getCost()>5000)
		//.forEach(System.out::println);
		
		//sorting 
		/*
		productService.getProducts().stream()
		.sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
		.filter(p->p.getCost()>5000)
		.map(p->p.getName().toUpperCase())
		.forEach(System.out::println);
		*/		
	/*	
	List<Product> filteredList=productService.getProductList().stream()
		.sorted((p1,p2)->p1.getName().compareTo(p2.getName()))
		.filter(p->p.getCost()>5000)
		.collect(Collectors.toList());
	
	//count
	System.out.println(filteredList.stream().count());
	*/
	
     //grouping
	
	Map<Integer,List<Product>> groupedProducts=productService.getProductList().parallelStream()
		.collect(Collectors.groupingBy(p->p.getStarRating()));
	
	 groupedProducts.forEach((starRating, e) -> 
	 System.out.format("StarRating %s: %s\n", starRating, e));

	/*
	Set productSet=groupedProducts.entrySet();
	
	Iterator iterator=productSet.iterator();
	
	Map.Entry<Integer, List<Product>> productEntries=null;
	while(iterator.hasNext())
	{
		productEntries=(Map.Entry<Integer, List<Product>>)iterator.next();
		System.out.println("Star Rating"+productEntries.getKey());
		System.out.println("========================================");
		productEntries.getValue().stream().forEach(System.out::println);
		System.out.println("========================================");
	}
	*/
	
	//All Match
	 List<String> traineeNames=new ArrayList<String>();
	 traineeNames.add("Satya");
	 traineeNames.add("Roshan");
	 traineeNames.add("Anita");
	 traineeNames.add("Krishnaveni");
	 traineeNames.add("Kamala");
	 
	System.out.println(traineeNames.stream().allMatch(n->n.startsWith("K")));
	System.out.println(traineeNames.stream().noneMatch(n->n.startsWith("Z")));
	 
	 //Optional 
	
	Optional<String> filteredTraineeNames=traineeNames.stream().filter(t->t.startsWith("K"))
			.findFirst();
	 
	
	 System.out.println(filteredTraineeNames.orElse("No Matching Name Found"));
	
		
	 Optional<Product> filteredProducts =productService.getProductList().stream()
			 .filter(p->p.getCost()>1000).findFirst();

	 System.out.println(filteredProducts.isPresent());
}
	
}
