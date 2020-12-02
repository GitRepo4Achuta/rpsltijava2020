package com.lti.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.inventory.dto.ErrorResponse;
import com.lti.inventory.models.Category;
import com.lti.inventory.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//adding categories
	@PostMapping("/categories")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
	{
		
		Category responseObj=categoryService.addCategory(category);
		if(responseObj!=null)
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseObj);
		else
		{
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body(new ErrorResponse("record not saved"));
		}
	}
	
	

}
