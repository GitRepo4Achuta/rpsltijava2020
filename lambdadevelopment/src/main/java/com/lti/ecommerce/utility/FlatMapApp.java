package com.lti.ecommerce.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.lti.ecommerce.models.Catalog;

public class FlatMapApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Catalog> catalogs=new ArrayList<Catalog>();
		
		Set<String> supplierSet=new HashSet<String>();
		supplierSet.add("Samsung");
		supplierSet.add("Nokia");
		supplierSet.add("LG");
		supplierSet.add("OnePlus");
		catalogs.add(new Catalog("Electronics",supplierSet));
		
		
		
		supplierSet=new HashSet<String>();
		supplierSet.add("Raymond");
		supplierSet.add("Kancheepuram Silk Sarees");
		supplierSet.add("BIBA");
		catalogs.add(new Catalog("Garments",supplierSet));
		
		//list the supplier names
		
	   List<String> supplierNames=catalogs.stream().map(c->c.getSupplierNames())
		.flatMap(s->s.stream())
		.collect(Collectors.toList());
	   
	   System.out.println(supplierNames);
		
	}

}
