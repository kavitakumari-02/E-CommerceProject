package com.e_commerce.project.items.service;

import java.util.List;
import java.util.Optional;
import com.e_commerce.project.items.additems.AddItems;

public interface AddPServiceHandler {
public AddItems saveAddItems(AddItems addItems); 
public List<AddItems>findAllAddItems(); 
public Optional<AddItems> findItemsById(int id);

}
