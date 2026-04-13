package com.e_commerce.project.category.service;


import java.util.List;
import java.util.Optional;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.items.additems.AddItems;

public interface ServiceHandler{
	 public Product addProduct(Product product);
	 public List<Product>findAllProduct();
	 public Optional<Product> EditProduct(int id);
	 public boolean deleteProduct(int id);
	 public Optional<Product> findProductById(int id);
	 public List<Product>getByCategorys(String category);
}
