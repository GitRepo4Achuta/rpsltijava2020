package com.lti.inventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.inventory.models.Category;
import com.lti.inventory.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepo;
	
	//insert
	public Category addCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	//update
	public  Category editCategory(Category category)
	{
		return categoryRepo.save(category);
	}
	
	//getall
	public  List<Category> getCategories()
	{
		return categoryRepo.findAll();
	}
	
	//where categoryId=?
	public Category getCategoryById(long categoryId)
	{
		
		return categoryRepo.findById(categoryId).orElse(null);
	}
	public List<Category> getCategoryByName(String name)
	{
		return categoryRepo.findByCategoryName(name);
	}
	public boolean deleteCategoryById(long categoryId)
	{
		
		boolean status=true;
		categoryRepo.deleteById(categoryId);		
		//check the existence		
		if(this.getCategoryById(categoryId)!=null)
			status=false;
		
		return status;
		
	}

}
