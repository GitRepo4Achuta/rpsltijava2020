package com.lti.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.inventory.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
