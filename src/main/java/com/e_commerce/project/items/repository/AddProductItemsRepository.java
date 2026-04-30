package com.e_commerce.project.items.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.items.additems.AddItems;

public interface AddProductItemsRepository extends JpaRepository<AddItems, Integer>{
List<AddItems> findAll();
public List<AddItems>findByCategory(String category);
}
