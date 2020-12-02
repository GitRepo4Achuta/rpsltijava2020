package com.lti.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lti.inventory.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //JPQL
	@Query("Select category from Category category where category.name=:categoryName")
	public List<Category> findByCategoryName(@Param("categoryName") String categoryName);
	
}
