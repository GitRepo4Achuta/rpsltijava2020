package com.lti.inventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.inventory.dto.ErrorResponse;
import com.lti.inventory.models.Category;
import com.lti.inventory.services.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	//adding categories
	@PostMapping({"/v1.0", "/v1.1"})
	//@CrossOrigin("*") //cors issue
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
	
	@PostMapping({"/v2.0"})
	//@CrossOrigin("*") //cors issue
	public ResponseEntity<?> addv2Category(@RequestBody Category category)
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
	@GetMapping({"/v1.0", "/v1.1"})
	//@CrossOrigin("*") //cors issue
	public ResponseEntity<?> getAllCategories()
	{
		
		List<Category> responseList=categoryService.getCategories();
		if(responseList.size()>0)
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseList);
		else
		{
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body(new ErrorResponse("No record found"));
		}
	}
	
	@GetMapping({"/v1.0/{categoryId}", "/v1.1/{categoryId}"})
	//@CrossOrigin("*") //cors issue
	public ResponseEntity<?> getCategoryById(@PathVariable("categoryId") long categoryId)
	{
		
		Category responseObj=categoryService.getCategoryById(categoryId);
		if(responseObj!=null)
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseObj);
		else
		{
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body(new ErrorResponse("No record found"));
		}
	}
	
	
	
	@GetMapping({"/v1.0/byname/{categoryName}", "/v1.1//byname/{categoryName}"})
	//@CrossOrigin("*") //cors issue
	public ResponseEntity<?> getCategoryByName(@PathVariable("categoryName") String categoryName)
	{
		
		List<Category> responseList=categoryService.getCategoryByName(categoryName);
		if(responseList.size()>0)
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseList);
		else
		{
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body(new ErrorResponse("No record found"));
		}
	}
	
	@DeleteMapping({"/v1.0/{categoryId}", "/v1.1/{categoryId}"})
	//@CrossOrigin("*") //cors issue
	public ResponseEntity<?> deleteCategoryById(@PathVariable("categoryId") long categoryId)
	{
		
		boolean status=categoryService.deleteCategoryById(categoryId);
		if(status)
		   return ResponseEntity.status(HttpStatus.ACCEPTED).body("Record Deleted");
		else
		{
			  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					  .body(new ErrorResponse("Couldn't delete Record, Record Not found"));
		}
	}
	
	//updating categories
		@PutMapping({"/v1.0", "/v1.1"})
		//@CrossOrigin("*") //cors issue
		public ResponseEntity<?> updateCategory(@RequestBody Category category)
		{
			
			Category responseObj=categoryService.editCategory(category);
			if(responseObj!=null)
			   return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseObj);
			else
			{
				  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						  .body(new ErrorResponse("record not updated"));
			}
		}

}
