package com.e_commerce.project.items.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.category.repository.ProductRepository;
import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.repository.AddProductItemsRepository;

@Service
public class AddPServiceImp implements AddPServiceHandler{
	@Autowired
   private ProductRepository productRepository;  
	@Autowired
private AddProductItemsRepository addProductItemsRepository;

    AddPServiceImp(AddProductItemsRepository addProductItemsRepository) {
        this.addProductItemsRepository = addProductItemsRepository;
    }
	@Override
	public AddItems saveAddItems(AddItems addItems) {
		
		return addProductItemsRepository.save(addItems);
	}
	
	public List<Product>getAllCategory(){
		
		return  productRepository.findAll();
		
	}
	@Override
	public List<AddItems>findAllAddItems() {
		return addProductItemsRepository.findAll();
		 
	}
	@Override
	public Optional<AddItems> findItemsById(int id) {
		
		 return addProductItemsRepository.findById(id);
		 
		
	}
	

	
}
