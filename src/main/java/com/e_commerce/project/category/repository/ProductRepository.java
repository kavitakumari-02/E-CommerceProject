package com.e_commerce.project.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.project.category.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
 public boolean existsByCategory(String category);
public List<Product>findAll();
public List<Product>findByCategory(String category);


}
