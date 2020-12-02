package com.lti.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.inventory.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
