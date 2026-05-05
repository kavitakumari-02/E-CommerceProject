package com.e_commerce.project.items.service;

import java.util.List;
import java.util.Optional;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.items.additems.AddItems;
import com.e_commerce.project.items.additems.Cart;

public interface AddPServiceHandler {
public AddItems saveAddItems(AddItems addItems); 
public List<AddItems>findAllAddItems(); 
public Optional<AddItems> findItemsById(int id);
public void AddToCart(int userId,int addItemsId);
public int getCartCountByUserId(int userId);
public List<AddItems>findByCategory(String category); 


}
