package com.e_commerce.project.category.service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.category.repository.ProductRepository;
import com.e_commerce.project.items.additems.AddItems;

@Service
public class ServiceHandlerImp implements ServiceHandler{
	@Autowired
 private ProductRepository productRepository;
	
	public boolean existsByCategory(String category) {
	
		return productRepository.existsByCategory(category);
	}
	//SAVE PRODUCT//
	 public Product addProduct(Product product) {
    return  productRepository.save(product);
	}
	 @Override
	 public List<Product> findAllProduct() {
		
		return productRepository.findAll();
	 }
	 @Override
	 public Optional<Product> EditProduct(int id) {
		
		return productRepository.findById(id);
	 }
	 @Override
	 public boolean deleteProduct(int id) {
		 if(productRepository.existsById(id)) {
			 productRepository.deleteById(id);
			 return true;
		 }
		
		return false;
	 }
	 @Override
	 public Optional<Product> findProductById(int id) {
		
		return productRepository.findById(id);
	 }
	public List<Product>getByCategorys(String category){
		
		return productRepository.findByCategory(category);
	}
	
}
