package com.lti.ecommerce.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	private long productId;
	private String name;
	private LocalDate dop;
	private long cost;
	private String brand;
	private int starRating;

	
}
