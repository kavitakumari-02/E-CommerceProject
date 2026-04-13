package com.e_commerce.project.items.service;

import java.util.List;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.items.additems.AddItems;

public interface AddPServiceHandler {
public AddItems saveAddItems(AddItems addItems); 
public List<AddItems>findAllAddItems(); 

}
